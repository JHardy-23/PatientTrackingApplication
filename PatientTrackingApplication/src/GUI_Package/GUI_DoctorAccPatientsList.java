package GUI_Package;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI_DoctorAccPatientsList {

	private JFrame frame;
	private JTable PatientsTable;
	private JTextField patientIDTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DoctorAccPatientsList window = new GUI_DoctorAccPatientsList();
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
	public GUI_DoctorAccPatientsList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		frame.getContentPane().setLayout(null);
		
		JLabel patientsTitleLabel = new JLabel("Patients");
		patientsTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		patientsTitleLabel.setFont(new Font("Algerian", Font.PLAIN, 35));
		patientsTitleLabel.setBounds(264, 38, 220, 33);
		frame.getContentPane().add(patientsTitleLabel);
		
		PatientsTable = new JTable();
		PatientsTable.setBounds(264, 112, 478, 422);
		frame.getContentPane().add(PatientsTable);
		
		JLabel patientIDLabel = new JLabel("Patient ID");
		patientIDLabel.setHorizontalAlignment(SwingConstants.LEFT);
		patientIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		patientIDLabel.setBounds(26, 116, 109, 33);
		frame.getContentPane().add(patientIDLabel);
		
		patientIDTextField = new JTextField();
		patientIDTextField.setBounds(26, 149, 225, 39);
		frame.getContentPane().add(patientIDTextField);
		patientIDTextField.setColumns(10);
		
		JButton addPatientButton = new JButton("Add Patient");
		addPatientButton.setBounds(51, 205, 171, 41);
		frame.getContentPane().add(addPatientButton);
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
