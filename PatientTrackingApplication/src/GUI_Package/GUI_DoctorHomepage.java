package GUI_Package;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_DoctorHomepage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DoctorHomepage window = new GUI_DoctorHomepage();
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
	public GUI_DoctorHomepage() {
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
		// Starter Page of Application
		JLabel RegistrationTitleLabel = new JLabel("Doctor Homepage");
		RegistrationTitleLabel.setFont(new Font("Algerian", Font.PLAIN, 50));
		RegistrationTitleLabel.setBounds(135, 0, 484, 91);
		frame.getContentPane().add(RegistrationTitleLabel);
		
		JButton PatientButton = new JButton("Patients");
		PatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PatientButton.setBounds(223, 201, 293, 41);
		frame.getContentPane().add(PatientButton);
		
		JButton AppointmentsButton = new JButton("Appointments");
		AppointmentsButton.setBounds(223, 286, 293, 41);
		frame.getContentPane().add(AppointmentsButton);
		
		JButton InformationButton = new JButton("Information");
		InformationButton.setBounds(223, 104, 293, 41);
		frame.getContentPane().add(InformationButton);
		
		JButton AccountButton = new JButton("Account");
		AccountButton.setBounds(223, 372, 293, 41);
		frame.getContentPane().add(AccountButton);
		
		JButton SignoutButton = new JButton("Sign Out");
		SignoutButton.setBounds(223, 463, 293, 41);
		frame.getContentPane().add(SignoutButton);
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
