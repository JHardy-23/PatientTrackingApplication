package GUI_Package;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class GUI_PatientAccDoctorsList {

	private JFrame frame;
	private JTable doctorsList;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_PatientAccDoctorsList window = new GUI_PatientAccDoctorsList();
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
	public GUI_PatientAccDoctorsList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		frame.getContentPane().setLayout(null);
		
		doctorsList = new JTable();
		doctorsList.setBounds(308, 98, 434, 436);
		frame.getContentPane().add(doctorsList);
		
		JLabel lblNewLabel = new JLabel("Doctor ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 112, 96, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel doctorsTitleLabel = new JLabel("Doctors");
		doctorsTitleLabel.setFont(new Font("Algerian", Font.PLAIN, 35));
		doctorsTitleLabel.setBounds(286, 37, 220, 33);
		frame.getContentPane().add(doctorsTitleLabel);
		
		textField = new JTextField();
		textField.setBounds(133, 112, 162, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Doctor");
		btnNewButton.setBounds(60, 173, 171, 41);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
