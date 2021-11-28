package GUI_Package;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GUI_PatientRegistrationPage {

	public JFrame frame;
	public JTextField LastNameTextField;
	public JTextField FirstNameTextField;
	public JTextField PhoneNumberTextField;
	public JTextField EmailTextField;
	public JTextField UserNameTextField;
	public JPasswordField passwordTextField;
	public JPasswordField RepeatPasswordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_PatientRegistrationPage window = new GUI_PatientRegistrationPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_PatientRegistrationPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// Starter Page of Application
		JLabel RegistrationTitleLabel = new JLabel("Patient Registration");
		RegistrationTitleLabel.setFont(new Font("Algerian", Font.PLAIN, 50));
		RegistrationTitleLabel.setBounds(96, 0, 585, 91);
		frame.getContentPane().add(RegistrationTitleLabel);
		
		JLabel LastNameLabel = new JLabel("Last Name");
		LastNameLabel.setBounds(274, 81, 155, 35);
		frame.getContentPane().add(LastNameLabel);
		
		LastNameTextField = new JTextField();
		LastNameTextField.setBounds(274, 119, 236, 39);
		frame.getContentPane().add(LastNameTextField);
		LastNameTextField.setColumns(10);
		
		JLabel FirstNameLabel = new JLabel("First Name");
		FirstNameLabel.setBounds(26, 81, 155, 35);
		frame.getContentPane().add(FirstNameLabel);
		
		FirstNameTextField = new JTextField();
		FirstNameTextField.setColumns(10);
		FirstNameTextField.setBounds(26, 119, 236, 39);
		frame.getContentPane().add(FirstNameTextField);
		
		JLabel PhoneNumberLabel = new JLabel("Phone Number");
		PhoneNumberLabel.setBounds(26, 172, 199, 33);
		frame.getContentPane().add(PhoneNumberLabel);
		
		PhoneNumberTextField = new JTextField();
		PhoneNumberTextField.setColumns(10);
		PhoneNumberTextField.setBounds(26, 211, 236, 39);
		frame.getContentPane().add(PhoneNumberTextField);
		
		JLabel EmailAddressLabel = new JLabel("Email");
		EmailAddressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		EmailAddressLabel.setBounds(274, 172, 199, 33);
		frame.getContentPane().add(EmailAddressLabel);
		
		EmailTextField = new JTextField();
		EmailTextField.setColumns(10);
		EmailTextField.setBounds(274, 211, 417, 39);
		frame.getContentPane().add(EmailTextField);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setBounds(26, 278, 199, 33);
		frame.getContentPane().add(UsernameLabel);
		
		UserNameTextField = new JTextField();
		UserNameTextField.setColumns(10);
		UserNameTextField.setBounds(26, 314, 236, 39);
		frame.getContentPane().add(UserNameTextField);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		PasswordLabel.setBounds(26, 381, 199, 33);
		frame.getContentPane().add(PasswordLabel);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblRepeatPassword.setBounds(299, 381, 236, 33);
		frame.getContentPane().add(lblRepeatPassword);
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.setBounds(302, 493, 171, 41);
		frame.getContentPane().add(RegisterButton);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(26, 418, 236, 39);
		frame.getContentPane().add(passwordTextField);
		
		RepeatPasswordTextField = new JPasswordField();
		RepeatPasswordTextField.setBounds(299, 418, 236, 39);
		frame.getContentPane().add(RepeatPasswordTextField);
	}

	public JButton getRegisterButton() {
		for(Component c : frame.getContentPane().getComponents()) {
			if( c instanceof JButton && ((JButton) c).getText().equals("Register") ) {
				return (JButton)c;
			}
		}
		return null;
	}
}
