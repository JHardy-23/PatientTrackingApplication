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
		frame.getContentPane().setBackground(new Color(128, 0, 0));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		frame.getContentPane().setLayout(null);
		
		doctorsList = new JTable();
		doctorsList.setBounds(308, 98, 434, 436);
		scrollPane = new JScrollPane(doctorsList);
		scrollPane.setBounds(doctorsList.getX(), doctorsList.getY(), doctorsList.getWidth(), doctorsList.getHeight());
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Doctor ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(26, 112, 172, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel doctorsTitleLabel = new JLabel("Doctors");
		doctorsTitleLabel.setForeground(new Color(255, 255, 255));
		doctorsTitleLabel.setFont(new Font("Algerian", Font.PLAIN, 45));
		doctorsTitleLabel.setBounds(239, 28, 281, 65);
		frame.getContentPane().add(doctorsTitleLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setBounds(26, 151, 236, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Doctor");
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.setBounds(36, 213, 171, 41);
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
