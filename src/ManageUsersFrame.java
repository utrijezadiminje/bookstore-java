import java.awt.EventQueue;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ManageUsersFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtRemoveUser;
	Connection conn = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUsersFrame frame = new ManageUsersFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageUsersFrame() {
		initialize();
		
	}
	void initialize() {
		conn = DBconnect.connect();
		//frame setup
		setTitle("Manage Users");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 716, 441);
		contentPane = new JPanel();
		contentPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				DBconnect.getUsers(Frame1.tableUsers);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				DBconnect.getUsers(table);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.setBounds(12, 12, 362, 342);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		//buttons
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(txtRemoveUser.getText());
					DBconnect.deleteUser(id);
					DBconnect.getUsers(table);
					DBconnect.getUsers(Frame1.tableUsers);
					txtRemoveUser.setText(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No user with given ID");
				}
			}
		});
		btnRemoveUser.setBounds(513, 12, 141, 27);
		contentPane.add(btnRemoveUser);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DBconnect.getUsers(Frame1.tableUsers);
			}
		});
		btnBack.setBounds(546, 292, 108, 27);
		contentPane.add(btnBack);
		//text boxes
		txtRemoveUser = new JTextField();
		txtRemoveUser.setBounds(386, 15, 114, 21);
		contentPane.add(txtRemoveUser);
		txtRemoveUser.setColumns(10);
		setResizable(false);
		
	}
}
