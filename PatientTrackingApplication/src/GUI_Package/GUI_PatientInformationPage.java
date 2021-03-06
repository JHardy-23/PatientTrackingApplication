package GUI_Package;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class GUI_PatientInformationPage {

	public JFrame frame;
	public JTextField firstNameTextField;
	public JTextField lastNameTextField;
	public JTextField DOBTextField;
	public JTextField textField;
	public JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_PatientInformationPage window = new GUI_PatientInformationPage();
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
	public GUI_PatientInformationPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 0, 0));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		frame.setBounds(100, 100, 775, 632);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel informationLabel = new JLabel("Information");
		informationLabel.setForeground(new Color(255, 228, 225));
		informationLabel.setFont(new Font("Algerian", Font.PLAIN, 35));
		informationLabel.setBounds(234, 28, 290, 41);
		frame.getContentPane().add(informationLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBackground(Color.WHITE);
		firstNameTextField.setEditable(false);
		firstNameTextField.setBounds(380, 89, 236, 39);
		frame.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setForeground(new Color(255, 255, 255));
		firstNameLabel.setBounds(49, 92, 177, 33);
		frame.getContentPane().add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setForeground(new Color(255, 255, 255));
		lastNameLabel.setBounds(49, 153, 177, 33);
		frame.getContentPane().add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setEditable(false);
		lastNameTextField.setColumns(10);
		lastNameTextField.setBackground(Color.WHITE);
		lastNameTextField.setBounds(380, 150, 236, 39);
		frame.getContentPane().add(lastNameTextField);
		
		JLabel DOBLabel = new JLabel("Date of Birth:");
		DOBLabel.setForeground(new Color(255, 255, 255));
		DOBLabel.setBounds(49, 214, 177, 33);
		frame.getContentPane().add(DOBLabel);
		
		DOBTextField = new JTextField();
		DOBTextField.setEditable(false);
		DOBTextField.setColumns(10);
		DOBTextField.setBackground(Color.WHITE);
		DOBTextField.setBounds(380, 211, 236, 39);
		frame.getContentPane().add(DOBTextField);
		
		JLabel DoctorsLabel = new JLabel("Doctors:");
		DoctorsLabel.setForeground(new Color(255, 255, 255));
		DoctorsLabel.setBounds(49, 275, 177, 33);
		frame.getContentPane().add(DoctorsLabel);
		
		JButton doctorsButton = new JButton("Click here for Doctors");
		doctorsButton.setBackground(new Color(255, 228, 225));
		doctorsButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		doctorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		doctorsButton.setBounds(380, 278, 236, 41);
		frame.getContentPane().add(doctorsButton);
		
		/*JLabel medHistoryLabel = new JLabel("Medical History:");
		medHistoryLabel.setBounds(49, 344, 226, 33);
		frame.getContentPane().add(medHistoryLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(380, 347, 236, 114);
		frame.getContentPane().add(textField);*/


		JLabel medHistoryLabel = new JLabel("Medical History:");
		medHistoryLabel.setForeground(new Color(255, 255, 255));
		medHistoryLabel.setBounds(49, 344, 226, 33);
		frame.getContentPane().add(medHistoryLabel);

		


		textArea = new JTextArea(2 , 20);
		textArea.setBounds(380,347,236,114);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

		JButton editButton = new JButton("Edit");
		editButton.setBackground(new Color(255, 228, 225));
		editButton.setBounds(270, 475, 171, 41);
		frame.getContentPane().add(editButton);
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
