package GUI_Package;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_DoctorAppointmentsPage {

	private JFrame frame;
	private JTextField dateTextField;
	private JTextField lastNameTextField;
	private JTextField firstNameTextField;
	private JTextField startTimeTextField;
	private JTextField endTimeTextField;
	DefaultTableModel model;
	private JTable PatientsList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DoctorAppointmentsPage window = new GUI_DoctorAppointmentsPage();
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
	public GUI_DoctorAppointmentsPage() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 768, 562);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lastNameLabel = new JLabel("Last Name :");
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lastNameLabel.setBounds(14, 178, 115, 33);
		panel.add(lastNameLabel);
		
		JLabel dateLabel = new JLabel("Date :");
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		dateLabel.setBounds(14, 129, 115, 33);
		panel.add(dateLabel);
		
		dateTextField = new JTextField();
		dateTextField.setBounds(132, 123, 178, 39);
		panel.add(dateTextField);
		dateTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(132, 172, 178, 39);
		panel.add(lastNameTextField);
		
		JLabel firstNameLabel = new JLabel("First Name :");
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		firstNameLabel.setBounds(14, 232, 115, 33);
		panel.add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(132, 226, 178, 39);
		panel.add(firstNameTextField);
		
		JLabel startTimeLabel = new JLabel("Start Time :");
		startTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		startTimeLabel.setBounds(14, 282, 115, 33);
		panel.add(startTimeLabel);
		
		startTimeTextField = new JTextField();
		startTimeTextField.setColumns(10);
		startTimeTextField.setBounds(132, 276, 178, 39);
		panel.add(startTimeTextField);
		
		JLabel endTimeLabel = new JLabel("End Time :");
		endTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		endTimeLabel.setBounds(14, 336, 115, 33);
		panel.add(endTimeLabel);
		
		endTimeTextField = new JTextField();
		endTimeTextField.setColumns(10);
		endTimeTextField.setBounds(132, 330, 178, 39);
		panel.add(endTimeTextField);
		
		JLabel appointmentsLabel = new JLabel("Appointments");
		appointmentsLabel.setFont(new Font("Algerian", Font.PLAIN, 40));
		appointmentsLabel.setBounds(222, 31, 343, 33);
		panel.add(appointmentsLabel);
		
		JButton requestButton = new JButton("Create New Appointment");
		requestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		requestButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		requestButton.setBounds(14, 397, 296, 41);
		panel.add(requestButton);
		
		PatientsList = new JTable();
		PatientsList.setBounds(326, 92, 416, 442);
		panel.add(PatientsList);
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
