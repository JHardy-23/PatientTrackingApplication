/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * FXML Controller class
 *
 * @author cmn68
 */
public class PatientDoctorsListGUIController {
    public GUI_Package.GUI_PatientAccDoctorsList gui;
    private Patient account;

    public PatientDoctorsListGUIController( Patient account ) {
        gui = new GUI_Package.GUI_PatientAccDoctorsList();
        this.account = account;
        gui.getButton("Add Doctor").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddDoctor();
            }
        });

        // Update Doctors List
        UpdateList();
    }

    private void AddDoctor() {
        // Check if inputted ID is a valid doctor id, let alone a valid id.
        if( gui.textField.getText().length() == 12 && gui.textField.getText().charAt(0) == '0' &&
                account.addDoctor(gui.textField.getText()) ) {
            // Figure out which doctor was added (for message)
            User user = null;
            for( User u : User.users ) {
                if( u.getID().equals(gui.textField.getText()) ) {
                    user = u;
                    break;
                }
            }

            // Connect doctor with patient
            if( !((Doctor)user).addPatient(account.getID()) ) {
                System.out.println("ERROR ADDING PATIENT ID TO DOCTOR LIST.");
                JOptionPane.showMessageDialog(gui.frame, "There was an error setting up the link between the doctor and patient. Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(gui.frame, "Successfully added Dr. " + user.getLname() + " to your list of doctors.", "Success!", JOptionPane.INFORMATION_MESSAGE);

            // Write changes to file.
            try {
                User.WriteSetToUserFile();
            }
            catch (Exception e) {
                System.out.println("Failed to write to users file.");
            }

            // Update Doctors List
            UpdateList();
        }
        else {
            JOptionPane.showMessageDialog(gui.frame, "Invalid text entry.\nPlease ensure that the entered ID is 12 characters long, and is valid.\nAdditionally, if the doctor appears in the list, you cannot add them again.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void UpdateList() {
        // Reset table
        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(new Object[] {"Full Name", "ID", "Email", "Phone Number"});

        // Add doctors to list
        for( String id : account.getDoctorIds() ) {
            for( User u : User.users ) {
                if( u.getID().equals(id) ) {
                    model.addRow(new Object[] {u.getFirstName() + " " + u.getLname(), id, u.getEmail(), u.getpNumber()});
                }
            }
        }

        // Set model to the new table model
        gui.doctorsList.setModel(model);
    }
}
