import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Frame1 {

	private JFrame frmBookstoreStanojevic;
	private JTextField textUserNo;
	private JLabel lblUserData;
	private int userNo;
	static JTable tableUsers;
	private JScrollPane scrollPane;
	static JTable tableInventory;
	private JScrollPane scrollPane_1;
	private JButton btnRefreshInventory;
	private JTable tableUserOrders;
	private JScrollPane scrollPane_2;
	private JLabel lblOrders;
	private JTextField textFieldCancelOrder;
	private static JLabel lblTotalPrice;
	private JLabel lblOrderABook;
	private JTextField textFieldOrderBookID;
	private JTextField textFieldQuantity;
	private JLabel lblBookId;
	private JLabel lblQuantity;
	private JLabel lblOrderId;
	private JLabel lblCancelAnOrder;
	private JButton btnOrder;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmBookstoreStanojevic.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	private static void calculatePrice(int id) {
		lblTotalPrice.setText("Total price: " + DBconnect.getTotalCustomerPrice(id));
	}
	public Frame1() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame setup

		frmBookstoreStanojevic = new JFrame();
		frmBookstoreStanojevic.setTitle("Bookstore Stanojevic");
		frmBookstoreStanojevic.setBounds(100, 100, 1128, 666);
		frmBookstoreStanojevic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBookstoreStanojevic.getContentPane().setLayout(null);
		frmBookstoreStanojevic.setResizable(false);
		
		
		//tables
		//table users
		
		tableUsers = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			DBconnect.getUsers(tableUsers);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.setViewportView(tableUsers);
		scrollPane.setBounds(39, 39, 524, 222);
		frmBookstoreStanojevic.getContentPane().add(scrollPane);
		//table user orders
		tableUserOrders = new JTable();
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportView(tableUserOrders);
		scrollPane_2.setBounds(760, 98, 327, 222);
		frmBookstoreStanojevic.getContentPane().add(scrollPane_2);
		//table inventory
		tableInventory = new JTable();
		scrollPane_1 = new JScrollPane();
		scrollPane_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				DBconnect.getInventory(tableInventory);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane_1.setViewportView(tableInventory);
		scrollPane_1.setBounds(39, 365, 524, 222);
		frmBookstoreStanojevic.getContentPane().add(scrollPane_1);
	
		//textboxes
		textUserNo = new JTextField();
		textUserNo.setBounds(760, 17, 52, 19);
		frmBookstoreStanojevic.getContentPane().add(textUserNo);
		textUserNo.setColumns(10);
		
		textFieldCancelOrder = new JTextField();
		textFieldCancelOrder.setBounds(982, 472, 85, 21);
		frmBookstoreStanojevic.getContentPane().add(textFieldCancelOrder);
		textFieldCancelOrder.setColumns(10);
		
		textFieldOrderBookID = new JTextField();
		textFieldOrderBookID.setBounds(743, 410, 95, 21);
		frmBookstoreStanojevic.getContentPane().add(textFieldOrderBookID);
		textFieldOrderBookID.setColumns(10);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(743, 443, 95, 21);
		frmBookstoreStanojevic.getContentPane().add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		//labels
		lblUserData = new JLabel("Active User");
		lblUserData.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserData.setVerticalAlignment(SwingConstants.TOP);
		lblUserData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserData.setBounds(917, 18, 187, 75);
		frmBookstoreStanojevic.getContentPane().add(lblUserData);
		
		JLabel lblUsers = new JLabel("Users");
		lblUsers.setFont(new Font("Dialog", Font.BOLD, 18));
		lblUsers.setBounds(39, 10, 63, 17);
		frmBookstoreStanojevic.getContentPane().add(lblUsers);
		
		JLabel lblBooks = new JLabel("Books");
		lblBooks.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBooks.setBounds(39, 337, 63, 17);
		frmBookstoreStanojevic.getContentPane().add(lblBooks);
		
		lblOrders = new JLabel("Orders");
		lblOrders.setBounds(760, 68, 63, 17);
		frmBookstoreStanojevic.getContentPane().add(lblOrders);
		
		lblBookId = new JLabel("Book ID:");
		lblBookId.setBounds(672, 412, 63, 17);
		frmBookstoreStanojevic.getContentPane().add(lblBookId);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(672, 445, 63, 17);
		frmBookstoreStanojevic.getContentPane().add(lblQuantity);
		
		lblOrderId = new JLabel("Order ID:");
		lblOrderId.setBounds(908, 474, 63, 17);
		frmBookstoreStanojevic.getContentPane().add(lblOrderId);
		
		lblCancelAnOrder = new JLabel("Cancel an order");
		lblCancelAnOrder.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCancelAnOrder.setBounds(908, 443, 118, 17);
		frmBookstoreStanojevic.getContentPane().add(lblCancelAnOrder);
		
		lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalPrice.setBounds(952, 337, 152, 17);
		frmBookstoreStanojevic.getContentPane().add(lblTotalPrice);
		
		lblOrderABook = new JLabel("Order a book");
		lblOrderABook.setFont(new Font("Dialog", Font.BOLD, 16));
		lblOrderABook.setBounds(672, 379, 140, 17);
		frmBookstoreStanojevic.getContentPane().add(lblOrderABook);
		
		
		//button refresh user list
		JButton btnRefreshUserList = new JButton("Refresh User List");
		btnRefreshUserList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBconnect.getUsers(tableUsers);
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnRefreshUserList.setBounds(40, 267, 146, 27);
		frmBookstoreStanojevic.getContentPane().add(btnRefreshUserList);
		//button choose user
		JButton btnChooseUser = new JButton("Choose");
		btnChooseUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					userNo = Integer.parseInt(textUserNo.getText());
					if(DBconnect.isUser(userNo)) {
					DBconnect.getUserOrders(userNo, tableUserOrders);
					calculatePrice(userNo);
					lblUserData.setText(DBconnect.getCustomerData(userNo));
					}
					else {
						throw new Exception();
					}
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No user with given ID");
				}
			}
		});
		btnChooseUser.setBounds(822, 16, 85, 21);
		frmBookstoreStanojevic.getContentPane().add(btnChooseUser);
		//button refresh inventory
		btnRefreshInventory = new JButton("Refresh Inventory");
		btnRefreshInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBconnect.getInventory(tableInventory);
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnRefreshInventory.setBounds(39, 594, 165, 27);
		frmBookstoreStanojevic.getContentPane().add(btnRefreshInventory);
		//button cancel order
		JButton btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBconnect.deleteOrder(userNo, Integer.parseInt(textFieldCancelOrder.getText()));
					DBconnect.getUserOrders(userNo,tableUserOrders);
					textFieldCancelOrder.setText(null);
					calculatePrice(userNo);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Order ID not valid!");
				}
			}
		});
		btnCancelOrder.setBounds(982, 505, 122, 27);
		frmBookstoreStanojevic.getContentPane().add(btnCancelOrder);
		//button order
		btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBconnect.customerOrderBook(userNo,
												Integer.parseInt(textFieldOrderBookID.getText()), 
												Integer.parseInt(textFieldQuantity.getText()));
					DBconnect.getUserOrders(userNo,tableUserOrders);
					textFieldOrderBookID.setText(null);
					textFieldQuantity.setText(null);
					calculatePrice(userNo);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid input!");
				}
			}
		});
		btnOrder.setBounds(726, 505, 108, 27);
		frmBookstoreStanojevic.getContentPane().add(btnOrder);
		//button register user
		JButton btnRegisterUser = new JButton("Register user");
		btnRegisterUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame registerFrame = new RegisterFrame();
				registerFrame.setVisible(true);
			}
		});
		btnRegisterUser.setBounds(262, 267, 146, 27);
		frmBookstoreStanojevic.getContentPane().add(btnRegisterUser);
		//button manage
		JButton btnManageUsers = new JButton("Manage users");
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageUsersFrame mngUsersFrame = new ManageUsersFrame();
				mngUsersFrame.setVisible(true);
			}
		});
		btnManageUsers.setBounds(423, 267, 140, 27);
		frmBookstoreStanojevic.getContentPane().add(btnManageUsers);
	}
}
