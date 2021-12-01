/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author cmn68
 */
public class DoctorHomepageGUIController {
    public GUI_Package.GUI_DoctorHomepage gui;
    private Doctor account;

    public DoctorHomepageGUIController(Doctor account) {
        gui = new GUI_Package.GUI_DoctorHomepage();
        this.account = account;
        gui.getButton("Patients").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoctorPatientsListGUIController pLController = new DoctorPatientsListGUIController(account);
                pLController.gui.frame.setLocation(gui.frame.getLocation()); // Move gui's location on screen to the starter page's location
                pLController.gui.frame.setVisible(true);
                gui.frame.setVisible(false);
                // Show this window again after the new window has closed.
                pLController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
                    public void windowClosed(WindowEvent event) {
                        gui.frame.setVisible(true);
                        gui.frame.setLocation(pLController.gui.frame.getLocation()); // Move gui's location to new GUI's location
                    }
                });
            }
        });
        gui.getButton("Appointments").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoctorAppointmentsGUIController dAController = new DoctorAppointmentsGUIController(account);
                dAController.gui.frame.setLocation(gui.frame.getLocation()); // Move gui's location on screen to the starter page's location
                dAController.gui.frame.setVisible(true);
                gui.frame.setVisible(false);
                // Show this window again after the new window has closed.
                dAController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
                    public void windowClosed(WindowEvent event) {
                        gui.frame.setVisible(true);
                        gui.frame.setLocation(dAController.gui.frame.getLocation()); // Move gui's location to new GUI's location
                    }
                });
            }
        });

        gui.getButton("Information").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoctorInformationGUIController DiController = new DoctorInformationGUIController(account);
                DiController.gui.frame.setLocation(gui.frame.getLocation());
                DiController.gui.frame.setVisible(true);
                gui.frame.setVisible(false);
                DiController.gui.frame.addWindowListener(new PatientTrackerWindowListener() {
                    public void windowClosed(WindowEvent event){
                        gui.frame.setVisible(true);
                        gui.frame.setLocation(DiController.gui.frame.getLocation());
                    }
                });
            }
        });

        gui.getButton("Account").addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e){
                String info = "User Name: " + account.getUsername() + "\n" + "Email: " + 
                account.getEmail();
                JOptionPane.showMessageDialog(gui.frame, info, "Account Info", JOptionPane.PLAIN_MESSAGE);
            }
        });

        gui.getButton("Sign Out").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.frame.dispose();
            }
        });
    }
}
