import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_PatientTrackerRegistrationMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_PatientTrackerRegistrationMenu window = new GUI_PatientTrackerRegistrationMenu();
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
	public GUI_PatientTrackerRegistrationMenu() {
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
		
		JLabel RegistrationTitle = new JLabel("Registration");
		RegistrationTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		RegistrationTitle.setBounds(242, 126, 273, 49);
		frame.getContentPane().add(RegistrationTitle);
		
		JButton RegisterDoctorButton = new JButton("I am a Doctor");
		RegisterDoctorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RegisterDoctorButton.setBounds(253, 297, 247, 41);
		frame.getContentPane().add(RegisterDoctorButton);
		
		JButton RegisterPatientButton = new JButton("I am a Patient");
		RegisterPatientButton.setBounds(253, 400, 247, 41);
		frame.getContentPane().add(RegisterPatientButton);
	}
}
