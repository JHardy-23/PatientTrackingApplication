/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;

/**
 * FXML Controller class
 *
 * @author cmn68
 */
public class PatientAppointmentsGUIController {
    public GUI_Package.GUI_PatientAppointmentsPage gui;
    private Patient account;

    public PatientAppointmentsGUIController( Patient account ) {
        gui = new GUI_Package.GUI_PatientAppointmentsPage();
        this.account = account;
        gui.getButton("Request New Appointment").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateAppointment();
            }
        });
        gui.getTable().addMouseListener(new PatientTrackerMouseListener() {
            public void mouseClicked(MouseEvent e) {
                int row = gui.getTable().rowAtPoint(e.getPoint());
                String dName = "", details = "";
                for( int i = 0; i < account.appointments.size(); i++ ) {
                    if (i == row) {
                        dName = account.appointments.get(i).getDoctorName();
                        details = account.appointments.get(i).getDetails();
                    }
                }
                JOptionPane.showMessageDialog(gui.frame,  "Appointment Details:\n" + (details.isEmpty() ? "Reason for appointment not specified." : details), "Appointment with Dr. " + dName, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Update Doctors List
        UpdateList();
    }

    private void CreateAppointment(){
        // Check if text fields are filled in
        if( gui.dateTextField.getText().isEmpty() || gui.endTimeTextField.getText().isEmpty() || gui.startTimeTextField.getText().isEmpty() || gui.firstNameTextField.getText().isEmpty() || gui.lastNameTextField.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Please ensure that you've filled out all text fields.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if name matches to a patient from their list of patients.
        Doctor doctor = GetDoctor();
        if( doctor == null )
            return;

        // Check if date and doesn't contain letters and is valid length
        String date = gui.dateTextField.getText();
        if( (date.length() != 8 && date.length() != 10) || !date.toLowerCase().equals(date.toUpperCase()) || date.charAt(2) != '/' || date.charAt(5) != '/' ) {
            JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Date must be in the following format:\nMM/DD/YY (or) MM/DD/YYYY.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if time frame is valid
        String start = gui.startTimeTextField.getText(), end = gui.endTimeTextField.getText();
        if( (start.charAt(1) != ':' && start.charAt(2) != ':') || (end.charAt(1) != ':' && end.charAt(2) != ':') || start.length() < 7 || end.length() < 7 || (start.indexOf("AM") == -1 && start.indexOf("PM") == -1) || (end.indexOf("AM") == -1 && end.indexOf("PM") == -1) ||
        !start.split(":")[0].toLowerCase().equals(start.split(":")[0].toUpperCase()) || !end.split(":")[0].toLowerCase().equals(end.split(":")[0].toUpperCase()) ||
        !start.split(":")[1].substring(0,2).toLowerCase().equals(start.split(":")[1].substring(0,2).toUpperCase()) || !end.split(":")[1].substring(0,2).toLowerCase().equals(end.split(":")[1].substring(0,2).toUpperCase()) ) {
            JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Time frames must be written in the following format:\n##:## AM (or) ##:## PM.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if time frame is valid
        int startHour, endHour, startMinutes, endMinutes;
        String startPeriod, endPeriod;
        try {
            // Parse ints
            String[] startSplits = start.split(":"), endSplits = end.split(":");
            startHour = Integer.parseInt(startSplits[0]);
            endHour = Integer.parseInt(endSplits[0]);
            startMinutes = Integer.parseInt(startSplits[1].substring(0,2));
            endMinutes = Integer.parseInt(endSplits[1].substring(0,2));

            // Determine period of day (AM/PM)
            startPeriod = startSplits[1].indexOf("AM") != -1 ? "AM" : "PM";
            endPeriod = endSplits[1].indexOf("AM") != -1 ? "AM" : "PM";
        }
        catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Time frames must be valid numerical times.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate time frame
        if ( startHour < endHour ) {
            if( startPeriod.equals("PM") && endPeriod.equals("AM") ) {
                JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Time frames cannot go into the next day", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        else if (startHour > endHour) {
            if( (startPeriod.equals("PM") && endPeriod.equals("AM")) || startPeriod.equals(endPeriod) ) {
                JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Time frames cannot go into the next day, nor backwards in time.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        else {
            if( startMinutes >= endMinutes ) {
                JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Time frames cannot go backwards in time, nor be the same time.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Check if time frame is not in the past
        Appointment newAppointment = new Appointment(startPeriod.equals("PM") ? startHour + 12 : startHour, startMinutes, endPeriod.equals("PM") ? endHour + 12 : endHour, endMinutes, date, doctor.getID(), account.getID());
        if(java.time.LocalDate.now().isAfter(newAppointment.getDate())) {
            JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. You cannot appointments cannot be made for a past time/date.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Time frame is valid. Now check if the time frame does not conflict with another appointment.
        for( Appointment a : account.getAppointments() ) {
            if( a.conflictsWith(newAppointment) ) {
                JOptionPane.showMessageDialog(gui.frame, "Unfortunately, the appointment specified conflicts with another appointment\nPlease refer to appointments list to correct this conflict.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Everything validated; send appointment request
        /**
         * Due to time constraints, this functionality is not available.
         */

        JOptionPane.showMessageDialog(gui.frame, "Successfully sent a request for an appointment with " + doctor.getFirstName() + " " + doctor.getLname() + ".", "Success!", JOptionPane.INFORMATION_MESSAGE);
    }

    private Doctor GetDoctor() {
        String doctors = "";
        for( String id : account.getDoctorIds() ) {
            for( User u : User.users ) {
                if( u.getID().equals(id) ) {
                    doctors += "??? " + u.getFirstName() + " " + u.getLname() + "\n";
                    if( u.getFirstName().equalsIgnoreCase(gui.firstNameTextField.getText()) && u.getLname().equalsIgnoreCase(gui.lastNameTextField.getText()) ) {
                        return (Doctor)u;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(gui.frame, "Invalid text entry. Dr. " + gui.lastNameTextField.getText() + ", does not exist\nList of doctors:\n" + doctors, "ERROR", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    private void UpdateList() {
        // Reset table
        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(new Object[] {"Start Time", "End Time", "Date", "Doctor"});

        // Add appointments to list
        for( Appointment a : account.getAppointments() ) {
            model.addRow(new Object[] {a.getStartTime().format(DateTimeFormatter.ofPattern("hh:mm:ss a", java.util.Locale.ENGLISH)), a.getEndTime().format(DateTimeFormatter.ofPattern("hh:mm:ss a", java.util.Locale.ENGLISH)), a.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy", java.util.Locale.ENGLISH)), a.getDoctorName()});
        }

        // Set model to the new table model
        gui.AppointmentsList.setModel(model);
    }
}
