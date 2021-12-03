package GUI_Package;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;

public class GUI_DoctorRegistrationPage {

	public JFrame frame;
	public JTextField DoctorIDTextField;
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
					GUI_DoctorRegistrationPage window = new GUI_DoctorRegistrationPage();
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
	public GUI_DoctorRegistrationPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 0, 0));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// Starter Page of Application
		JLabel RegistrationTitleLabel = new JLabel("Doctor Registration");
		RegistrationTitleLabel.setForeground(new Color(255, 255, 255));
		RegistrationTitleLabel.setFont(new Font("Algerian", Font.PLAIN, 50));
		RegistrationTitleLabel.setBounds(96, 0, 585, 91);
		frame.getContentPane().add(RegistrationTitleLabel);
		
		JLabel DoctorIDLabel = new JLabel("Doctor ID");
		DoctorIDLabel.setForeground(new Color(255, 255, 255));
		DoctorIDLabel.setBounds(26, 81, 155, 35);
		frame.getContentPane().add(DoctorIDLabel);
		
		DoctorIDTextField = new JTextField();
		DoctorIDTextField.setBounds(26, 119, 155, 39);
		frame.getContentPane().add(DoctorIDTextField);
		DoctorIDTextField.setColumns(10);
		
		JLabel LastNameLabel = new JLabel("Last Name");
		LastNameLabel.setForeground(new Color(255, 255, 255));
		LastNameLabel.setBounds(450, 81, 155, 35);
		frame.getContentPane().add(LastNameLabel);
		
		LastNameTextField = new JTextField();
		LastNameTextField.setBounds(455, 119, 236, 39);
		frame.getContentPane().add(LastNameTextField);
		LastNameTextField.setColumns(10);
		
		JLabel FirstNameLabel = new JLabel("First Name");
		FirstNameLabel.setForeground(new Color(255, 255, 255));
		FirstNameLabel.setBounds(203, 81, 155, 35);
		frame.getContentPane().add(FirstNameLabel);
		
		FirstNameTextField = new JTextField();
		FirstNameTextField.setColumns(10);
		FirstNameTextField.setBounds(205, 119, 236, 39);
		frame.getContentPane().add(FirstNameTextField);
		
		JLabel PhoneNumberLabel = new JLabel("Phone Number");
		PhoneNumberLabel.setForeground(new Color(255, 255, 255));
		PhoneNumberLabel.setBounds(26, 172, 199, 33);
		frame.getContentPane().add(PhoneNumberLabel);
		
		PhoneNumberTextField = new JTextField();
		PhoneNumberTextField.setColumns(10);
		PhoneNumberTextField.setBounds(26, 211, 236, 39);
		frame.getContentPane().add(PhoneNumberTextField);
		
		JLabel EmailAddressLabel = new JLabel("Email");
		EmailAddressLabel.setForeground(new Color(255, 255, 255));
		EmailAddressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		EmailAddressLabel.setBounds(274, 172, 199, 33);
		frame.getContentPane().add(EmailAddressLabel);
		
		EmailTextField = new JTextField();
		EmailTextField.setColumns(10);
		EmailTextField.setBounds(274, 211, 417, 39);
		frame.getContentPane().add(EmailTextField);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setForeground(new Color(255, 255, 255));
		UsernameLabel.setBounds(26, 278, 199, 33);
		frame.getContentPane().add(UsernameLabel);
		
		UserNameTextField = new JTextField();
		UserNameTextField.setColumns(10);
		UserNameTextField.setBounds(26, 314, 236, 39);
		frame.getContentPane().add(UserNameTextField);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setForeground(new Color(255, 255, 255));
		PasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		PasswordLabel.setBounds(26, 381, 199, 33);
		frame.getContentPane().add(PasswordLabel);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setForeground(new Color(255, 255, 255));
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblRepeatPassword.setBounds(299, 381, 236, 33);
		frame.getContentPane().add(lblRepeatPassword);
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.setBackground(new Color(255, 228, 225));
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
