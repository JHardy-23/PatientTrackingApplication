/*The PatientRegistrationGUI java class is after the user selects I am a patient in Registration Menu and this class displays information the patient needs to input. 
 *This class should have labels of what information the patient needs to enter using text fields.
 *Then a confirmation button to complete the registration.
 * 
 * */
import java.awt.EventQueue;

import javax.swing.JFrame;

public class PatientRegistrationGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientRegistrationGUI window = new PatientRegistrationGUI();
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
	public PatientRegistrationGUI() {
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
