package GUI_Package;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI_DoctorInformationPage {

	public JFrame frame;
	public JTextField suffixTextField;
	public JTextField firstNametectField;
	public JTextField lastNameTextField;
	public JTextField professionTextField;
	public JTextField educationTextField;
	public JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DoctorInformationPage window = new GUI_DoctorInformationPage();
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
	public GUI_DoctorInformationPage() {
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
		informationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		informationLabel.setForeground(new Color(255, 255, 255));
		informationLabel.setBackground(new Color(255, 255, 255));
		informationLabel.setFont(new Font("Algerian", Font.PLAIN, 35));
		informationLabel.setBounds(201, 28, 310, 33);
		frame.getContentPane().add(informationLabel);
		
		
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		firstNameLabel.setForeground(new Color(255, 255, 255));
		firstNameLabel.setBounds(49, 127, 226, 33);
		frame.getContentPane().add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lastNameLabel.setForeground(new Color(255, 255, 255));
		lastNameLabel.setBounds(49, 184, 236, 33);
		frame.getContentPane().add(lastNameLabel);
		
		
		JLabel professionLabel = new JLabel("Profession:");
		professionLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		professionLabel.setForeground(new Color(255, 255, 255));
		professionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		professionLabel.setBounds(49, 245, 218, 33);
		frame.getContentPane().add(professionLabel);
		
		
		JLabel PatientsLabel = new JLabel("Patients:");
		PatientsLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		PatientsLabel.setForeground(new Color(255, 255, 255));
		PatientsLabel.setBounds(49, 306, 200, 33);
		frame.getContentPane().add(PatientsLabel);
		
		JButton PatientsButton = new JButton("Click here for Patients");
		PatientsButton.setBackground(new Color(255, 228, 225));
		PatientsButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		PatientsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PatientsButton.setBounds(384, 306, 236, 41);
		frame.getContentPane().add(PatientsButton);
		
		JButton editButton = new JButton("Edit");
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		editButton.setBackground(new Color(255, 228, 225));
		editButton.setBounds(270, 475, 171, 41);
		frame.getContentPane().add(editButton);
		
		JLabel educationLabel = new JLabel("Education:");
		educationLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		educationLabel.setForeground(new Color(255, 255, 255));
		educationLabel.setBounds(49, 367, 226, 33);
		frame.getContentPane().add(educationLabel);
		
		JLabel SuffixLabel = new JLabel("Suffix :");
		SuffixLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		SuffixLabel.setForeground(new Color(255, 255, 255));
		SuffixLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SuffixLabel.setBounds(49, 76, 194, 33);
		frame.getContentPane().add(SuffixLabel);
		
		suffixTextField = new JTextField();
		suffixTextField.setFont(new Font("Tahoma", Font.PLAIN, 35));
		suffixTextField.setBounds(384, 73, 236, 39);
		frame.getContentPane().add(suffixTextField);
		suffixTextField.setColumns(10);
		suffixTextField.setEditable(false);
		suffixTextField.setBackground(Color.WHITE);
		
		firstNametectField = new JTextField();
		firstNametectField.setBounds(384, 124, 236, 39);
		frame.getContentPane().add(firstNametectField);
		firstNametectField.setColumns(10);
		firstNametectField.setEditable(false);
		firstNametectField.setBackground(Color.WHITE);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(384, 181, 236, 39);
		frame.getContentPane().add(lastNameTextField);
		lastNameTextField.setColumns(10);
		lastNameTextField.setEditable(false);
		lastNameTextField.setBackground(Color.WHITE);

		professionTextField = new JTextField();
		professionTextField.setBounds(384, 242, 236, 39);
		frame.getContentPane().add(professionTextField);
		professionTextField.setColumns(10);
		professionTextField.setEditable(false);
		professionTextField.setBackground(Color.WHITE);
		
		/*
		educationTextField = new JTextField();
		educationTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		educationTextField.setBounds(384, 368, 283, 95);
		frame.getContentPane().add(educationTextField);
		educationTextField.setColumns(10);
		educationTextField.setEditable(false);
		educationTextField.setBackground(Color.WHITE);*/

		textArea = new JTextArea(2 , 20);
		textArea.setBounds(384,368,283,95);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

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
