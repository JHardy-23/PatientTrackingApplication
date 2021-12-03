package GUI_Package;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class GUI_PatientTrackerLoginPage {

	public JFrame frame;
	public JTextField UsernameTextField;
	public JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_PatientTrackerLoginPage window = new GUI_PatientTrackerLoginPage();
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
	public GUI_PatientTrackerLoginPage() {
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
		JLabel HomepageTitle = new JLabel("Patient Tracker");
		HomepageTitle.setForeground(new Color(255, 255, 255));
		HomepageTitle.setFont(new Font("Algerian", Font.PLAIN, 60));
		HomepageTitle.setBounds(110, 28, 585, 91);
		frame.getContentPane().add(HomepageTitle);
		
		JLabel LoginTitleLabel = new JLabel("Login");
		LoginTitleLabel.setForeground(new Color(255, 255, 255));
		LoginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		LoginTitleLabel.setBounds(242, 126, 273, 49);
		frame.getContentPane().add(LoginTitleLabel);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setForeground(new Color(255, 255, 255));
		UsernameLabel.setBounds(87, 269, 157, 33);
		frame.getContentPane().add(UsernameLabel);
		
		UsernameTextField = new JTextField();
		UsernameTextField.setBounds(416, 266, 254, 39);
		frame.getContentPane().add(UsernameTextField);
		UsernameTextField.setColumns(10);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setForeground(new Color(255, 255, 255));
		PasswordLabel.setBounds(87, 345, 157, 33);
		frame.getContentPane().add(PasswordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(416, 342, 254, 39);
		frame.getContentPane().add(passwordTextField);
		
		JButton SignInButton = new JButton("Login");
		SignInButton.setBackground(new Color(255, 228, 225));
		SignInButton.setBounds(291, 436, 171, 41);
		frame.getContentPane().add(SignInButton);
		
		JButton forgotPasswordButton = new JButton("Forgot Password?");
		forgotPasswordButton.setBackground(new Color(255, 228, 225));
		forgotPasswordButton.setForeground(new Color(0, 0, 0));
		forgotPasswordButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		forgotPasswordButton.setBounds(524, 390, 146, 23);
		frame.getContentPane().add(forgotPasswordButton);
		
		JButton Login_RegisterButton = new JButton("Don't have an account? Click Here");
		Login_RegisterButton.setBackground(new Color(255, 228, 225));
		Login_RegisterButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Login_RegisterButton.setBounds(268, 487, 220, 23);
		frame.getContentPane().add(Login_RegisterButton);
	}

	public JButton getButton(String text) {
		for(Component c : frame.getContentPane().getComponents()) {
			if( c instanceof JButton && ((JButton) c).getText().equals(text) ) {
				return (JButton)c;
			}
		}
		return null;
	}
}
