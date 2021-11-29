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
        gui.getButton("Sign Out").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.frame.dispose();
            }
        });
    }
}
