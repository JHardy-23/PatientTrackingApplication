package GUI_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_ForgotPasswordPage {

	private JFrame frame;
	private JTextField emailAddresstextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ForgotPasswordPage window = new GUI_ForgotPasswordPage();
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
	public GUI_ForgotPasswordPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1142, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel ForgotPassTitleLabel = new JLabel("Forgot Password?");
		ForgotPassTitleLabel.setFont(new Font("Algerian", Font.PLAIN, 40));
		ForgotPassTitleLabel.setBounds(373, 28, 378, 33);
		frame.getContentPane().add(ForgotPassTitleLabel);
		
		JLabel informationLabel = new JLabel("Enter the email associated with your account and we'll send an email with instructions to reset your password");
		informationLabel.setVerticalAlignment(SwingConstants.TOP);
		informationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		informationLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		informationLabel.setBounds(26, 85, 1058, 40);
		frame.getContentPane().add(informationLabel);
		
		emailAddresstextField = new JTextField();
		emailAddresstextField.setBounds(322, 168, 429, 39);
		frame.getContentPane().add(emailAddresstextField);
		emailAddresstextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email Address");
		lblNewLabel_2.setBounds(322, 126, 185, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton submitButton = new JButton("Submit ");
		submitButton.setBounds(454, 235, 171, 41);
		frame.getContentPane().add(submitButton);
	}

}
