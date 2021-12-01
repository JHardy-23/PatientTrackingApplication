package GUI_Package;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI_DoctorAccPatientsList {

	public JFrame frame;
	public JTable PatientsTable;
	public JTextField firstNameTextField;
	public JTextField lastNameTextField;
	public JScrollPane scrollPane;

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
		PatientsTable.setBackground(new Color(255, 228, 225));
		PatientsTable.setBounds(264, 112, 478, 422);
		scrollPane = new JScrollPane(PatientsTable);
		scrollPane.setBounds(PatientsTable.getX(), PatientsTable.getY(), PatientsTable.getWidth(), PatientsTable.getHeight());
		frame.getContentPane().add(scrollPane);
		
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
		addPatientButton.setBackground(new Color(255, 228, 225));
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

	public JButton getButton(String text) {
		for(Component c : frame.getContentPane().getComponents()) {
			if( c instanceof JButton && ((JButton) c).getText().equals(text) ) {
				return (JButton)c;
			}
		}
		return null;
	}
}
