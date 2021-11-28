/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                break;
            case 1:
                DoctorRegistrationGUIController dController = new DoctorRegistrationGUIController();
                dController.gui.frame.setLocation(gui.frame.getLocation()); // Move gui's location on screen to the starter page's location
                dController.gui.frame.setVisible(true);
                break;
            default:
                return;
        }
    }

    public void OpenForgotPasswordDialog() {
        // Add code to change password using dialogs (JUSTIN WILL CODE THIS PART)
    }

    public void AttemptLogin() {
        // Check login credentials and see if the user can be logged into.
    }
}
