package GUI_Package;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI_PatientTrackerStarterPage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_PatientTrackerStarterPage window = new GUI_PatientTrackerStarterPage();
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
	public GUI_PatientTrackerStarterPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 0, 0));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// Starter Page of Application
		JLabel HomepageTitle = new JLabel("Patient Tracker");
		HomepageTitle.setForeground(new Color(255, 255, 255));
		HomepageTitle.setFont(new Font("Algerian", Font.PLAIN, 60));
		HomepageTitle.setBounds(110, 28, 585, 91);
		frame.getContentPane().add(HomepageTitle);
		
		JButton PatientButton = new JButton("Sign In");
		PatientButton.setBackground(new Color(255, 228, 225));
		PatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PatientButton.setBounds(469, 469, 197, 41);
		frame.getContentPane().add(PatientButton);
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.setBackground(new Color(255, 228, 225));
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RegisterButton.setBounds(102, 469, 197, 41);
		frame.getContentPane().add(RegisterButton);
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
