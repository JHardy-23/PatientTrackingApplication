import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class GUI_PatientTrackerLoginPage {

	private JFrame frame;
	private JTextField UsernameTextField;
	private JPasswordField passwordTextField;

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
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// Starter Page of Application
		JLabel HomepageTitle = new JLabel("Patient Tracker");
		HomepageTitle.setFont(new Font("Algerian", Font.PLAIN, 60));
		HomepageTitle.setBounds(110, 28, 585, 91);
		frame.getContentPane().add(HomepageTitle);
		
		JLabel LoginTitleLabel = new JLabel("Login");
		LoginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		LoginTitleLabel.setBounds(242, 126, 273, 49);
		frame.getContentPane().add(LoginTitleLabel);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setBounds(87, 269, 157, 33);
		frame.getContentPane().add(UsernameLabel);
		
		UsernameTextField = new JTextField();
		UsernameTextField.setBounds(416, 266, 254, 39);
		frame.getContentPane().add(UsernameTextField);
		UsernameTextField.setColumns(10);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(87, 345, 157, 33);
		frame.getContentPane().add(PasswordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(416, 342, 254, 39);
		frame.getContentPane().add(passwordTextField);
		
		JButton SignInButton = new JButton("Login");
		SignInButton.setBounds(291, 424, 171, 41);
		frame.getContentPane().add(SignInButton);
	}

}
