/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author cmn68
 */
public class LoginGUIController {
    public GUI_Package.GUI_PatientTrackerLoginPage gui;

    public LoginGUIController() {
        gui = new GUI_Package.GUI_PatientTrackerLoginPage();
        gui.getButton("Don't have an account? Click Here").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OpenRegistrationGUI();
            }
        });
        gui.getButton("Forgot Password?").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OpenForgotPasswordDialog();
            }
        });
        gui.getButton("Login").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AttemptLogin();
            }
        });
    }

    private void OpenRegistrationGUI() {
        Object[] options = {"Patient", "Doctor", "Nevermind"};
        int choice = JOptionPane.showOptionDialog(gui.frame, "Which new type of user would you are you?", "Select User Type", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options, options[2]);
        switch (choice) {
            case 0:
                PatientRegistrationGUIController pController = new PatientRegistrationGUIController();
                pController.gui.frame.setLocation(gui.frame.getLocation()); // Move gui's location on screen to the starter page's location
                pController.gui.frame.setVisible(true);
                gui.frame.setVisible(false);
                // Show this window again after the new window has closed.
                pController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
                    public void windowClosed(WindowEvent event) {
                        gui.frame.setVisible(true);
                        gui.frame.setLocation(pController.gui.frame.getLocation()); // Move gui's location to new GUI's location
                    }
                });
                break;
            case 1:
                DoctorRegistrationGUIController dController = new DoctorRegistrationGUIController();
                dController.gui.frame.setLocation(gui.frame.getLocation()); // Move gui's location on screen to the starter page's location
                dController.gui.frame.setVisible(true);
                gui.frame.setVisible(false);
                // Show this window again after the new window has closed.
                dController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
                    public void windowClosed(WindowEvent event) {
                        gui.frame.setVisible(true);
                        gui.frame.setLocation(dController.gui.frame.getLocation()); // Move gui's location to new GUI's location
                    }
                });
                break;
            default:
                return;
        }
    }

    public void OpenForgotPasswordDialog() {
        ForgotPasswordGUIController fPController = new ForgotPasswordGUIController();
        fPController.gui.frame.setLocation(gui.frame.getLocation()); // Move gui's location on screen to the starter page's location
        fPController.gui.frame.setVisible(true);
        gui.frame.setVisible(false);
        // Show this window again after the new window has closed.
        fPController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
            public void windowClosed(WindowEvent event) {
                gui.frame.setVisible(true);
                gui.frame.setLocation(fPController.gui.frame.getLocation()); // Move gui's location to new GUI's location
            }
        });
    }

    public void AttemptLogin() {
        // Check if credentials were filled out
        if( gui.UsernameTextField.getText().isEmpty() || gui.passwordTextField.getText().isEmpty() ) {
            // Print error message
            JOptionPane.showMessageDialog(gui.frame, "Incomplete text entries. Please fill in all text fields.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update Users HashSet
        try {
            User.ReadSetFromUserFile();
        }
        catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return;
        }

        // Compare credentials
        User account = null;
        for( User u : User.users ) {
            if( u.getUsername().equals(gui.UsernameTextField.getText()) ) {
                // Found user
                account = u;
            }
        }

        // Check if user was found
        if( account == null ) {
            JOptionPane.showMessageDialog(gui.frame, "The account with the username " + gui.UsernameTextField.getText() + " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // User was found, check if password is correct
        else if( !account.getPass().equals(gui.passwordTextField.getText()) ) {
            JOptionPane.showMessageDialog(gui.frame, "Incorrect login credentials. Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Password is correct, transition to homepage
        // Clear text fields
        gui.UsernameTextField.setText("");
        gui.passwordTextField.setText("");

        // Login
        if( account.getID().charAt(0) != '0' ) {
            /// PATIENT
            PatientHomepageGUIController pController = new PatientHomepageGUIController((Patient)account);
            pController.gui.frame.setLocation(gui.frame.getLocation()); // Move gui's location on screen to the starter page's location
            pController.gui.frame.setVisible(true);
            gui.frame.setVisible(false);
            // Show this window again after the new window has closed.
            pController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
                public void windowClosed(WindowEvent event) {
                    gui.frame.setVisible(true);
                    gui.frame.setLocation(pController.gui.frame.getLocation()); // Move gui's location to new GUI's location
                }
            });
        }
        else {
            /// DOCTOR
            DoctorHomepageGUIController dController = new DoctorHomepageGUIController((Doctor)account);
            dController.gui.frame.setLocation(gui.frame.getLocation()); // Move gui's location on screen to the starter page's location
            dController.gui.frame.setVisible(true);
            gui.frame.setVisible(false);
            // Show this window again after the new window has closed.
            dController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
                public void windowClosed(WindowEvent event) {
                    gui.frame.setVisible(true);
                    gui.frame.setLocation(dController.gui.frame.getLocation()); // Move gui's location to new GUI's location
                }
            });
        }
    }
}
