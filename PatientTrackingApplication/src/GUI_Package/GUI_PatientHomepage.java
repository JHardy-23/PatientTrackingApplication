package GUI_Package;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI_PatientHomepage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_PatientHomepage window = new GUI_PatientHomepage();
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
	public GUI_PatientHomepage() {
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
		JLabel HomepageTitle = new JLabel("Patient Homepage");
		HomepageTitle.setFont(new Font("Algerian", Font.PLAIN, 50));
		HomepageTitle.setBounds(135, 0, 484, 91);
		frame.getContentPane().add(HomepageTitle);
		
		JButton DoctorsButton = new JButton("Doctors");
		DoctorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DoctorsButton.setBounds(223, 195, 293, 41);
		frame.getContentPane().add(DoctorsButton);
		
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
