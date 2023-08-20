import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RegisterFrame extends JFrame{

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtPhoneNumber;
	private JLabel labelNameError;
	private JLabel labelLastNameError;
	private JLabel labelAddressError;
	private JLabel labelCityError;
	private JLabel labelNumberError;
	Connection conn = null;
	private JLabel lblName;
	private JLabel lblLastName;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblPhoneNumber;
	/**
	 * Create the frame.
	 */
	public RegisterFrame() {
		initialize();
	}
	void initialize() {
		
		conn = DBconnect.connect();
		setTitle("Register User");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		//Name text field
		txtName = new JTextField();
		txtName.setBounds(162, 38, 114, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		//Last name text field
		txtLastName = new JTextField();
		txtLastName.setBounds(162, 71, 114, 21);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		//Address txt
		txtAddress = new JTextField();
		txtAddress.setBounds(162, 104, 114, 21);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		//City txt
		txtCity = new JTextField();
		txtCity.setBounds(162, 137, 114, 21);
		contentPane.add(txtCity);
		txtCity.setColumns(10);
		//phone tx
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(162, 170, 114, 21);
		contentPane.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		//button reggister
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					labelNameError.setText(null);
					labelLastNameError.setText(null);
					labelAddressError.setText(null);
					labelCityError.setText(null);
					labelNumberError.setText(null);
					String nameString = txtName.getText();
					String lastNameString = txtLastName.getText();
					String addressString = txtAddress.getText();
					String cityString = txtCity.getText();
					String phoneString = txtPhoneNumber.getText();
					String errorString = "missing";
					System.out.println(nameString);
					if(txtName.getText().trim().length()!=0
					&& txtLastName.getText().trim().length()!=0
					&& txtAddress.getText().trim().length()!=0
					&& txtCity.getText().trim().length()!=0
					&& txtPhoneNumber.getText().trim().length()!=0) {
						DBconnect.registerUser(nameString, lastNameString, addressString, cityString, phoneString);
						DBconnect.getUsers(Frame1.tableUsers);
						setVisible(false);
					}
					else {
						if(txtName.getText().trim().length()==0) {
							labelNameError.setText(errorString);
						}
						if(txtLastName.getText().trim().length()==0) {
							labelLastNameError.setText(errorString);
						}
						if(txtAddress.getText().trim().length()==0) {
							labelAddressError.setText(errorString);
						}
						if(txtCity.getText().trim().length()==0) {
							labelCityError.setText(errorString);
						}
						if(txtPhoneNumber.getText().trim().length()==0) {
							labelNumberError.setText(errorString);
						}
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null, "Missing input data!");
					
					e1.printStackTrace();
				}
				
			}
		});
		btnRegister.setBounds(168, 211, 108, 27);
		contentPane.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setBounds(328, 211, 108, 27);
		contentPane.add(btnBack);
		
		//labels
		labelNameError = new JLabel("");
		labelNameError.setBounds(282, 40, 63, 17);
		contentPane.add(labelNameError);
		
		labelLastNameError = new JLabel("");
		labelLastNameError.setBounds(282, 73, 63, 17);
		contentPane.add(labelLastNameError);
		
		labelAddressError = new JLabel("");
		labelAddressError.setBounds(282, 106, 63, 17);
		contentPane.add(labelAddressError);
		
		labelCityError = new JLabel("");
		labelCityError.setBounds(282, 139, 63, 17);
		contentPane.add(labelCityError);
		
		labelNumberError = new JLabel("");
		labelNumberError.setBounds(282, 172, 63, 17);
		contentPane.add(labelNumberError);
		
		lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(92, 40, 63, 17);
		contentPane.add(lblName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(79, 73, 76, 17);
		contentPane.add(lblLastName);
		
		lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(92, 106, 63, 17);
		contentPane.add(lblAddress);
		
		lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(92, 139, 63, 17);
		contentPane.add(lblCity);
		
		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setBounds(41, 172, 114, 17);
		contentPane.add(lblPhoneNumber);
	}
}
