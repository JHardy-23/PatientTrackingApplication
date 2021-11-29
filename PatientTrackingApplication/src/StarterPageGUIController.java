/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class StarterPageGUIController {
    public GUI_Package.GUI_PatientTrackerStarterPage gui;

    public StarterPageGUIController() {
        gui = new GUI_Package.GUI_PatientTrackerStarterPage();
        gui.getButton("Register").addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                OpenRegistrationGUI();
            }
        });
        gui.getButton("Sign In").addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                OpenSignInGUI();
            }
        });
    }

    private void OpenRegistrationGUI() {
        Object[] options = {"Patient", "Doctor", "Nevermind"};
        int choice = JOptionPane.showOptionDialog(gui.frame, "Which new type of user are you?", "Select User Type", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options, options[2]);
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

    private void OpenSignInGUI() {
        LoginGUIController lController = new LoginGUIController();
        lController.gui.frame.setLocation(gui.frame.getLocation()); // Move gui's location on screen to the starter page's location
        lController.gui.frame.setVisible(true);
        gui.frame.setVisible(false);
        // Show this window again after the new window has closed.
        lController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
            public void windowClosed(WindowEvent event) {
                gui.frame.setVisible(true);
                gui.frame.setLocation(lController.gui.frame.getLocation()); // Move gui's location to new GUI's location
            }
        });
    }
}
