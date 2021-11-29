import java.util.HashSet;
import java.util.Random;
import java.io.*;
import java.util.ArrayList;

/**
 * The patient class represents patients that go to the docotrs office, each patient
 * will have their own ID and Password which are added to a hashset
 */
public class Patient extends User implements Serializable {
    private String patientId, dateOfBirth, medicalHistory;
    private ArrayList<String> doctorIds;

    /**
     * Constructor for the patient class
     */
    public Patient(String Fname, String Lname, String username, String phoneNumber, String emailAddress, String password){
        this.Fname = Fname;
        this.Lname = Lname;
        this.patientId = generateId();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.Password = password;
        this.emailAddress = emailAddress;
        this.doctorIds = new ArrayList<String>();
        this.appointments = new ArrayList<Appointment>();
        this.dateOfBirth = "";
        this.medicalHistory = "";
    }

    /**
     * Constructor for a patient that may be a dependent on an insurance plan
     */
    public Patient(String Fname, String Lname){
        this.Fname = Fname;
        this.Lname = Lname;
        this.patientId = generateId();
        this.doctorIds = new ArrayList<String>();
        this.appointments = new ArrayList<Appointment>();
        this.dateOfBirth = "";
        this.medicalHistory = "";
    }


    public String getID() {
        return patientId;
    }

    public ArrayList<String> getDoctorIds() {
        return doctorIds;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public boolean addDoctor( String id ) {
        // Check if ID for doctor exists, or if doctor already is associated
        if( ids.contains(id) && !doctorIds.contains(id) ) {
            // Search for doctor with that id
            for( User u : users ) {
                if( u.getID().equals(id) ) {
                    // Add doctor id to list
                    doctorIds.add(id);
                    return true;
                }
            }
        }

        // ID does not exist, or doctor is already associated
        return false;
    }

    @Override
    public int hashCode() {
        return patientId.hashCode();
    }

    /**
     * Method that returns a string about the patient object in an 
     * organized fashion
     */
    public String toString(){
        String toString = "First name: " + this.Fname +  "\nLast name: " + this.Lname + "\nUsername: " + this.username
         + "\nPatient ID: " + this.patientId + "\nPhone Number: " + this.phoneNumber + "\nAssociated Doctor Ids: \n";
        for( String id : doctorIds)
            toString += id + "\n ";
        return toString;
    }

}
