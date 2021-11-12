/*The PatientTrackerLoginGUI java class will consist of labels and text fields that will be used to ask the patient or doctor logging on to input their email and password.
 * There will be a confirmation button which will send the user to their account.
 * */
import java.awt.EventQueue;

import javax.swing.JFrame;

public class PatientTrackerLoginGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientTrackerLoginGUI window = new PatientTrackerLoginGUI();
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
	public PatientTrackerLoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	
}
