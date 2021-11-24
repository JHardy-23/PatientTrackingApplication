/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.control.DialogPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author cmn68
 */
public class DoctorRegistrationGUIController {
    private GUI_Package.GUI_DoctorRegistrationPage gui;

    public DoctorRegistrationGUIController() {
        gui = new GUI_Package.GUI_DoctorRegistrationPage();
        gui.getRegisterButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int verifyResult = VerifyTextFields();
                switch(verifyResult) {
                    case 0:
                        if( ReadDoctorsFromFile() && WriteDoctorsToFile() ) {
                            JOptionPane.showMessageDialog(gui.frame, "Successfully registered new doctor.", "Success!", JOptionPane.INFORMATION_MESSAGE);
                            // Signal main to open Home Page
                        }
                        else {
                            JOptionPane.showMessageDialog(gui.frame, "Failed to register new doctor. Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
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
        if( gui.DoctorIDTextField.getText().length() == 0 ||
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

    private boolean ReadDoctorsFromFile() {

        return true;
    }

    private boolean WriteDoctorsToFile() {

        return true;
    }

    public static void main(String[] args) {
        DoctorRegistrationGUIController controller = new DoctorRegistrationGUIController();
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
