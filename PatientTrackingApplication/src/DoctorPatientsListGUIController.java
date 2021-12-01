/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * FXML Controller class
 *
 * @author cmn68
 */
public class DoctorPatientsListGUIController {
    public GUI_Package.GUI_DoctorAccPatientsList gui;
    private Doctor account;

    public DoctorPatientsListGUIController( Doctor account ) {
        gui = new GUI_Package.GUI_DoctorAccPatientsList();
        this.account = account;
        gui.getButton("Add Patient").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddPatient();
            }
        });

        // Update Doctors List
        UpdateList();
    }

    private void AddPatient() {
        // Check if inputted First & Last name is matches a patient's first and last name
        if( !InputsValid() ) {
            return;
        }

        // Check how many patients have the same name.
        ArrayList<Patient> patients = new ArrayList<Patient>();
        for( User u : User.users ) {
            if( u.getFirstName().equalsIgnoreCase(gui.firstNameTextField.getText()) && u.getLname().equalsIgnoreCase(gui.lastNameTextField.getText()) && u instanceof Patient && !account.getPatientIds().contains(u.getID()) ) {
                patients.add((Patient)u);
            }
        }

        // If there is more than one patient with the name, ask the doctor to choose which one is correct.
        if( patients.size() > 1 ) {
            Object[] options = new Object[patients.size()];
            for( int i = 0; i < options.length; i++ ) {
                options[i] = "Username: " + patients.get(i).getUsername() + ", Email: " + patients.get(i).getEmail() + ", ID: " + patients.get(i).getID();
            }

            String chosen = (String)JOptionPane.showInputDialog(gui.frame, "There are multiple patients in the system with this name.\nPlease select the patient whose details match you patient's details.:", "Select Patient", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if( chosen == null ) {
                // Action cancelled, reset text fields and exit this function.
                JOptionPane.showMessageDialog(gui.frame, "Add patient action has been cancelled.", "Action Cancelled", JOptionPane.INFORMATION_MESSAGE);
                gui.firstNameTextField.setText("");
                gui.lastNameTextField.setText("");
                return;
            }
            else {
                for( int i = 0; i < options.length; i++ ) {
                    if( options[i].equals(chosen) ) {
                        // Add Patient to Doctor's list
                        patients.get(i).addDoctor(account.getID());

                        // Add Doctor to Patient's list
                        account.addPatient(patients.get(i).getID());

                        // Notify user of function success
                        JOptionPane.showMessageDialog(gui.frame, "Successfully added " + patients.get(i).getFirstName() + " " + patients.get(i).getLname() + " to your list of patients.", "Success!", JOptionPane.INFORMATION_MESSAGE);

                        // Write changes to file.
                        try {
                            User.WriteSetToUserFile();
                        }
                        catch (Exception e) {
                            System.out.println("Failed to write to users file.");
                        }

                        // Update Patients List
                        UpdateList();
                    }
                }
            }
        }
        else if( patients.size() == 1 ) {
            // Add Patient to Doctor's list
            patients.get(0).addDoctor(account.getID());

            // Add Doctor to Patient's list
            account.addPatient(patients.get(0).getID());

            // Ask if they are sure they'd like to add the patient
            JOptionPane.showConfirmDialog(gui.frame, "Are you sure you'd like to add " + patients.get(0).getFirstName() + " " + patients.get(0).getLname() + " to your list of patients?\nUsername: " + patients.get(0).getUsername() + "\nEmail: " + patients.get(0).getEmail(), "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null );

            // Notify user of function success
            JOptionPane.showMessageDialog(gui.frame, "Successfully added " + patients.get(0).getFirstName() + " " + patients.get(0).getLname() + " to your list of patients.", "Success!", JOptionPane.INFORMATION_MESSAGE);

            // Write changes to file.
            try {
                User.WriteSetToUserFile();
            }
            catch (Exception e) {
                System.out.println("Failed to write to users file.");
            }

            // Update Patients List
            UpdateList();
        }
        else {
            JOptionPane.showMessageDialog(gui.frame, "There was an error loading the available patients. Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private boolean InputsValid() {
        // Check if inputs were entered.
        if( gui.firstNameTextField.getText().isEmpty() || gui.lastNameTextField.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. You must enter in the first and last name of the patient to add them.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if the name matches with a patient in the system.
        for( User u : User.users ) {
            if( u.getFirstName().equalsIgnoreCase(gui.firstNameTextField.getText()) && u.getLname().equalsIgnoreCase(gui.lastNameTextField.getText()) && u instanceof Patient && !account.getPatientIds().contains(u.getID()) ) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(gui.frame, "ERROR. No patient with the name, " + gui.firstNameTextField.getText() + " " + gui.lastNameTextField.getText() + " found on the system.", "ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    private int GetAppointmentCount( Patient patient ) {
        int count = 0;
        for( Appointment a : account.getAppointments() ) {
            if( patient.getAppointments().contains(a) && account.getAppointments().contains(a) ) {
                count++;
            }
        }
        return count;
    }

    private void UpdateList() {
        // Reset table
        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(new Object[] {"Full Name", "ID", "Email", "Phone Number", "# of Appts"});

        // Add doctors to list
        for( String id : account.getPatientIds() ) {
            for( User u : User.users ) {
                if( u.getID().equals(id) ) {
                    model.addRow(new Object[] {u.getFirstName() + " " + u.getLname(), id, u.getEmail(), u.getpNumber(), GetAppointmentCount((Patient)u)});
                }
            }
        }

        // Set model to the new table model
        gui.PatientsTable.setModel(model);
    }
}
