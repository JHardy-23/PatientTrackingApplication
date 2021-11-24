/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.*;

import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author cmn68
 */
public class PatientRegistrationGUIController {

    private GUI_Package.GUI_PatientRegistrationPage gui;

    public PatientRegistrationGUIController() {
        gui = new GUI_Package.GUI_PatientRegistrationPage();
        gui.getRegisterButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int verifyResult = VerifyTextFields();
                switch(verifyResult) {
                    case 0:
                        try {
                            // Get updated HashSet from serialized HashSet file
                            ///User.ReadSetFromUserFile();

                            // Add new user to users HashSet
                            ///User.AddUser(new Patient(gui.FirstNameTextField.getText(), gui.LastNameTextField.getText(), gui.UserNameTextField.getText(), gui.PhoneNumberTextField.getText(), gui.EmailTextField.getText(), gui.passwordTextField.getText()));

                            // Write new HashSet to serialized HashSet file
                            ///User.WriteSetToUserFile();

                            // Display success message
                            JOptionPane.showMessageDialog(gui.frame, "Successfully registered new patient.", "Success!", JOptionPane.INFORMATION_MESSAGE);

                            // Signal main to open Home Page
                            // ADD CODE
                        }
                        catch(Exception ex) {
                            JOptionPane.showMessageDialog(gui.frame, "Failed to register new patient. Please try again.\nError: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(gui.frame, "Incomplete text entries. Please fill in all text fields.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(gui.frame, "Incomplete text entries. Please enter a valid email address.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Please enter a valid phone number using only numbers.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        });
    }

    private int VerifyTextFields() {
        if( gui.PatientIDTextField.getText().length() == 0 ||
                gui.UserNameTextField.getText().length() == 0 ||
                gui.passwordTextField.getText().length() == 0 ||
                gui.RepeatPasswordTextField.getText().length() == 0 ||
                gui.EmailTextField.getText().length() == 0 ||
                gui.PhoneNumberTextField.getText().length() == 0 ||
                gui.FirstNameTextField.getText().length() == 0 ||
                gui.LastNameTextField.getText().length() == 0 )
            return 1; // Incomplete entry (text field empty)
        else if( !gui.EmailTextField.getText().contains("@") )
            return 2; // Invalid email (does not contain @ sign)
        else if( !gui.PhoneNumberTextField.getText().toUpperCase().equals(gui.PhoneNumberTextField.getText().toLowerCase()) )
            return 3; // Invalid phone number (does not have only numbers)
        return 0; // Valid input
    }

    public static void main(String[] args) {
        PatientRegistrationGUIController controller = new PatientRegistrationGUIController();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    controller.gui.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
}
