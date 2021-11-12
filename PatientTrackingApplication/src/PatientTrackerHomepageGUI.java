/*The PatientTrackerHomepageGUI java class displays the register and login button, each button should take the user to the respective GUIs. 
 * The Registration button should move to the Registration Menu page.
 * The Sign in button should move to the Login Page.
 * */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PatientTrackerHomepageGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientTrackerHomepageGUI window = new PatientTrackerHomepageGUI();
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
	public PatientTrackerHomepageGUI() {
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
		
		JButton PatientButton = new JButton("Sign In");
		PatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PatientButton.setBounds(469, 469, 197, 41);
		frame.getContentPane().add(PatientButton);
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RegisterButton.setBounds(102, 469, 197, 41);
		frame.getContentPane().add(RegisterButton);
	}
}
