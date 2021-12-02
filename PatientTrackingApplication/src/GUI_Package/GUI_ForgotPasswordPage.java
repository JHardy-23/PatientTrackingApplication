package GUI_Package;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_ForgotPasswordPage {

	public JFrame frame;
	public JTextField emailAddresstextField;

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
		frame.getContentPane().setBackground(new Color(128, 0, 0));
		frame.setBounds(100, 100, 1142, 420);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel ForgotPassTitleLabel = new JLabel("Forgot Password?");
		ForgotPassTitleLabel.setForeground(new Color(255, 255, 255));
		ForgotPassTitleLabel.setFont(new Font("Algerian", Font.PLAIN, 40));
		ForgotPassTitleLabel.setBounds(373, 28, 378, 33);
		frame.getContentPane().add(ForgotPassTitleLabel);
		
		JLabel informationLabel = new JLabel("Enter the email associated with your account and we'll send an email with instructions to reset your password");
		informationLabel.setForeground(new Color(255, 255, 255));
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
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(322, 126, 185, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBackground(new Color(255, 228, 225));
		submitButton.setBounds(454, 235, 171, 41);
		frame.getContentPane().add(submitButton);
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
