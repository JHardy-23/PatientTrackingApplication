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
import java.awt.Color;

public class GUI_DoctorAccPatientsList {

	private JFrame frame;
	private JTable PatientsTable;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;

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
		frame.setBackground(new Color(253, 245, 230));
		frame.getContentPane().setBackground(new Color(128, 0, 0));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		frame.getContentPane().setLayout(null);
		
		JLabel patientsTitleLabel = new JLabel("Patients");
		patientsTitleLabel.setForeground(new Color(255, 255, 255));
		patientsTitleLabel.setBackground(new Color(255, 255, 255));
		patientsTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		patientsTitleLabel.setFont(new Font("Algerian", Font.PLAIN, 50));
		patientsTitleLabel.setBounds(220, 28, 291, 56);
		frame.getContentPane().add(patientsTitleLabel);
		
		PatientsTable = new JTable();
		PatientsTable.setBackground(new Color(255, 240, 245));
		PatientsTable.setBounds(264, 112, 478, 422);
		frame.getContentPane().add(PatientsTable);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setForeground(new Color(255, 255, 255));
		firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		firstNameLabel.setBounds(26, 116, 109, 33);
		frame.getContentPane().add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(26, 149, 225, 39);
		frame.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		JButton addPatientButton = new JButton("Add Patient");
		addPatientButton.setForeground(Color.DARK_GRAY);
		addPatientButton.setBackground(new Color(255, 192, 203));
		addPatientButton.setBounds(53, 298, 171, 41);
		frame.getContentPane().add(addPatientButton);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setForeground(new Color(255, 255, 255));
		lastNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lastNameLabel.setBounds(26, 194, 109, 33);
		frame.getContentPane().add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(26, 231, 225, 39);
		frame.getContentPane().add(lastNameTextField);
		frame.setBounds(100, 100, 800, 651);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
