import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class DBconnect {
	static String userName = "username";
	static String password = "password";
	static String url = "jdbc:sqlserver://212.235.190.203;databaseName=Bookstore;integratedSecurity=false;trustServerCertificate=true;";
	static Connection conn = null;
	public static Connection connect() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			return conn;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public static void getInventory(JTable table) {
		try {
			conn = connect();
			String query = "SELECT * FROM Inventory;";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			stmt.close();
			conn.close();
		}
		catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
	}
	public static void getUsers(JTable table) {
		try {
		conn = connect();
		String query = "SELECT * FROM customerList;";
		PreparedStatement pst = conn.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		rs.close();
		pst.close();
		conn.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void getUserOrders(int id, JTable table) {
		try {
			conn = connect();
			String query = "EXECUTE [dbo].[getUserOrders] "+ Integer.toString(id)+";";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No user with given ID");
		}
		
	}
	public static String getTotalCustomerPrice(int id) {
		
		try {
			conn = connect();
			CallableStatement cstmt1;
			cstmt1 = conn.prepareCall("{call dbo.getTotalCustomerPrice(?,?)}");
			cstmt1.setInt(1, id);
			cstmt1.registerOutParameter(2, java.sql.Types.DECIMAL);//total price
			cstmt1.execute();
			String r = Double.toString(cstmt1.getDouble(2));
			cstmt1.close();
			conn.close();
			return (r + " eur");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No user with given ID");
			return null;
			
		}
		
	}
	public static boolean isUser(int id) {
		try {
		conn = connect();
		CallableStatement cstmt0 = conn.prepareCall("{call dbo.isUser(?,?)}");
		cstmt0.setInt(1, id);
		cstmt0.registerOutParameter(2, java.sql.Types.INTEGER);
		cstmt0.execute();
		int bul = cstmt0.getInt(2);
		cstmt0.close();
		conn.close();
		return (bul==1) ? true : false;
		}
		catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
			return false;
			// TODO: handle exception
		}
	}
	public static String getCustomerData(int id) {
		try {
			conn = connect();
			CallableStatement cstmt0 = conn.prepareCall("{call dbo.getCustomerData(?,?,?,?,?,?)}");
			cstmt0.setInt(1, id);
			cstmt0.registerOutParameter(2, java.sql.Types.NVARCHAR);//Name
			cstmt0.registerOutParameter(3, java.sql.Types.NVARCHAR);//LastName
			cstmt0.registerOutParameter(4, java.sql.Types.NVARCHAR);//Address
			cstmt0.registerOutParameter(5, java.sql.Types.NVARCHAR);//City
			cstmt0.registerOutParameter(6, java.sql.Types.NVARCHAR);//PhoneNo
			cstmt0.execute();
			String r = "<html>" + cstmt0.getString(2) + " " + cstmt0.getString(3) + "<br>" + cstmt0.getString(4) + ", " + cstmt0.getString(5) + "<br>"+  cstmt0.getString(6) + "</html>";
			cstmt0.close();
			conn.close();
			return r;
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "No user with given ID");
			return null;
		}
	}
	public static String getUserName(int id) {
		try {
				conn = connect();
				CallableStatement cstmt1;
				cstmt1 = conn.prepareCall("{call dbo.getUserName(?,?)}");
				cstmt1.setInt(1, id);
				cstmt1.registerOutParameter(2, java.sql.Types.NVARCHAR);
				cstmt1.execute();
				String r = cstmt1.getString(2);
				cstmt1.close();
				conn.close();
				return r;

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public static String getUserLastName(int id) {
		try {
				conn = connect();
				CallableStatement cstmt1;
				cstmt1 = conn.prepareCall("{call dbo.getUserLastName(?,?)}");
				cstmt1.setInt(1, id);
				cstmt1.registerOutParameter(2, java.sql.Types.NVARCHAR);
				cstmt1.execute();
				String r = cstmt1.getString(2);
				cstmt1.close();
				conn.close();
				return r;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public static String getUserAddress(int id) {
		try {
				conn = connect();
				CallableStatement cstmt1;
				cstmt1 = conn.prepareCall("{call dbo.getUserAddress(?,?)}");
				cstmt1.setInt(1, id);
				cstmt1.registerOutParameter(2, java.sql.Types.NVARCHAR);
				cstmt1.execute();
				String r = cstmt1.getString(2);
				cstmt1.close();
				conn.close();
				return r;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public static String getUserCity(int id) {
		try {
				conn = connect();
				CallableStatement cstmt1;
				cstmt1 = conn.prepareCall("{call dbo.getUserCity(?,?)}");
				cstmt1.setInt(1, id);
				cstmt1.registerOutParameter(2, java.sql.Types.NVARCHAR);
				cstmt1.execute();
				String r = cstmt1.getString(2);
				cstmt1.close();
				conn.close();
				return r;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public static String getUserPhone(int id) {
		try {
				conn = connect();
				CallableStatement cstmt1;
				cstmt1 = conn.prepareCall("{call dbo.getUserPhone(?,?)}");
				cstmt1.setInt(1, id);
				cstmt1.registerOutParameter(2, java.sql.Types.NVARCHAR);
				cstmt1.execute();
				String r = cstmt1.getString(2);
				cstmt1.close();
				conn.close();
				return r;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public static void customerOrderBook(int id, int book, int quantity) {
		try {
			conn = connect();
			CallableStatement cstmt0 = conn.prepareCall("{call dbo.customerOrderBook(?,?,?)}");
			cstmt0.setInt(1, id);
			cstmt0.setInt(2, book);
			cstmt0.setInt(3, quantity);
			cstmt0.execute();
			cstmt0.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Invalid Input!");
		}
	}
	public static void registerUser(String nameString, String lastNameString, String addressString, String cityString, String phoneNumberString) {
		try {
			conn = connect();
			CallableStatement cstmt1 = conn.prepareCall("{call dbo.registerUser(?,?,?,?,?)}");
			cstmt1.setString(1,nameString);
			cstmt1.setString(2,lastNameString);
			cstmt1.setString(3,addressString);
			cstmt1.setString(4,cityString);
			cstmt1.setString(5,phoneNumberString);
			cstmt1.execute();
			cstmt1.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//deletes
	public static void deleteUser(int id) {
		try {
			conn = connect();
			CallableStatement cstmt1 = conn.prepareCall("{call dbo.deleteUser(?)}");
			cstmt1.setInt(1, id);
			cstmt1.execute();
			cstmt1.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No user with given ID");
		}
	}
	public static void deleteOrder(int id,int orderNo) {
		try {
			conn = connect();
			CallableStatement cstmt0 = conn.prepareCall("{call dbo.deleteOrder(?,?)}");
			cstmt0.setInt(1, orderNo);
			cstmt0.setInt(2, id);
			cstmt0.execute();
			cstmt0.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No order with given ID");
		}
	}
	
}
