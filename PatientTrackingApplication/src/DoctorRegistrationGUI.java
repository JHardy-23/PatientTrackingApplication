/*The DoctorRegistrationGUI java class is after the doctor selects I am a doctor in Registration Menu and this class displays information the dotor needs to input. 
 *This class should have labels of what information the doctor needs to enter using text fields.
 *Then a confirmation button to complete the registration
 * 
 * */
import java.awt.EventQueue;

import javax.swing.JFrame;

public class DoctorRegistrationGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorRegistrationGUI window = new DoctorRegistrationGUI();
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
	public DoctorRegistrationGUI() {
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
