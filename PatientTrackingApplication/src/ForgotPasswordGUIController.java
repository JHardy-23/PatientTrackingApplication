/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * FXML Controller class
 *
 * @author cmn68
 */
public class ForgotPasswordGUIController {
    public GUI_Package.GUI_ForgotPasswordPage gui;

    public ForgotPasswordGUIController() {
        gui = new GUI_Package.GUI_ForgotPasswordPage();
        gui.getButton("Submit").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SendEmail();
            }
        });
    }

    private void SendEmail() {
        // Code *would* send an email, but due to project time contraints this will not actually do anything
        // Check if email is valid
        if( gui.emailAddresstextField.getText().contains("@") ) {
            JOptionPane.showMessageDialog(gui.frame, "Email was successfully sent to email, " + gui.emailAddresstextField.getText() + "!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            gui.frame.dispose();
        }
        else {
            JOptionPane.showMessageDialog(gui.frame, "Incomplete text entries. Please enter a valid email address.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
