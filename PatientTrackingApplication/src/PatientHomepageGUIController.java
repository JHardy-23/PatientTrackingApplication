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
public class PatientHomepageGUIController {
    public GUI_Package.GUI_PatientHomepage gui;
    private Patient account;

    public PatientHomepageGUIController(Patient account) {
        gui = new GUI_Package.GUI_PatientHomepage();
        this.account = account;
        gui.getButton("Doctors").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientDoctorsListGUIController dLController = new PatientDoctorsListGUIController(account);
                dLController.gui.frame.setLocation(gui.frame.getLocation()); // Move gui's location on screen to the starter page's location
                dLController.gui.frame.setVisible(true);
                gui.frame.setVisible(false);
                // Show this window again after the new window has closed.
                dLController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
                    public void windowClosed(WindowEvent event) {
                        gui.frame.setVisible(true);
                        gui.frame.setLocation(dLController.gui.frame.getLocation()); // Move gui's location to new GUI's location
                    }
                });
            }
        });

        gui.getButton("Information").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientInformationGUIController PiController = new PatientInformationGUIController(account);
                PiController.gui.frame.setLocation(gui.frame.getLocation());
                PiController.gui.frame.setVisible(true);
                gui.frame.setVisible(false);
                PiController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
                    public void windowClosed(WindowEvent event){
                        gui.frame.setVisible(true);
                        gui.frame.setLocation(PiController.gui.frame.getLocation());
                    }
                });
            }
        });

        gui.getButton("Sign Out").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.frame.dispose();
            }
        });
    }
}
