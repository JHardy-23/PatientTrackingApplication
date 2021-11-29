package GUI_Package;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class GUI_PatientAccDoctorsList {

	public JFrame frame;
	public JTable doctorsList;
	public JTextField textField;
	public JScrollPane scrollPane;

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
		scrollPane = new JScrollPane(doctorsList);
		scrollPane.setBounds(doctorsList.getX(), doctorsList.getY(), doctorsList.getWidth(), doctorsList.getHeight());
		frame.getContentPane().add(scrollPane);
		
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
