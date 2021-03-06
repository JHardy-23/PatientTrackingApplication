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

    public GUI_Package.GUI_PatientRegistrationPage gui;

    public PatientRegistrationGUIController() {
        gui = new GUI_Package.GUI_PatientRegistrationPage();
        gui.getRegisterButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int verifyResult = VerifyTextFields();
                String message = "Invalid text entry.\n\n";
                switch(verifyResult) {
                    case 0:
                        try {
                            // Get updated HashSet from serialized HashSet file
                            User.ReadSetFromUserFile();

                            // Validate username
                            if( User.usernameExists(gui.UserNameTextField.getText()) ) {
                                JOptionPane.showMessageDialog(gui.frame, "Failed to register new patient. The entered username is taken.", "ERROR", JOptionPane.ERROR_MESSAGE);
                                break;
                            }

                            // Add new user to users HashSet
                            User.AddUser(new Patient(gui.FirstNameTextField.getText(), gui.LastNameTextField.getText(), gui.UserNameTextField.getText(), gui.PhoneNumberTextField.getText(), gui.EmailTextField.getText(), gui.passwordTextField.getText()));

                            // Write new HashSet to serialized HashSet file
                            User.WriteSetToUserFile();

                            // Display success message
                            JOptionPane.showMessageDialog(gui.frame, "Successfully registered new patient.", "Success!", JOptionPane.INFORMATION_MESSAGE);

                            // Signal main to open Home Page
                            gui.frame.dispose();
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
                    case 4:
                        JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Please enter a valid phone number that is 10 digits long.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(gui.frame, "Invalid text entries. Passwords do not match.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Password must be between 8 and 16 characters in length.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        });
    }

    private int VerifyTextFields() {
        if( gui.UserNameTextField.getText().length() == 0 ||
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
        else if( gui.PhoneNumberTextField.getText().length() != 10 )
            return 4; // Invalid phone number (not correct length)
        else if( !gui.passwordTextField.getText().equals(gui.RepeatPasswordTextField.getText()) )
            return 5; // Passwords do not match
        else if( gui.passwordTextField.getText().length() < 8 || gui.passwordTextField.getText().length() > 16 )
            return 6; // Password is not of correct length
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
