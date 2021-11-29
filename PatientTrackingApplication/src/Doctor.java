import java.util.HashSet;
import java.util.Random;
import java.io.*;
import java.util.ArrayList;

/**
 * The Doctor class represents doctors that work at the establishment, each doctor will have their
 * own ID and password which are checked using a hashset.
 */

public class Doctor extends User implements Serializable {
    private String docId;
    private ArrayList<String> patientIds;

    /**
     * Constructor for the Doctor object
     */
    public Doctor(String First, String Last, String uName, String emailAdd, String Pass, String pNumber, String docId) {
        this.Fname = First;
        this.Lname = Last;
        this.username = uName;
        this.docId = docId;
        this.phoneNumber = pNumber;
        this.emailAddress = emailAdd;
        this.Password = Pass;
        this.patientIds = new ArrayList<String>();
        this.appointments = new ArrayList<Appointment>();
    }

    public String getID() {
        return docId;
    }

    public ArrayList<String> getPatientIds() {
        return patientIds;
    }

    public boolean addPatient(String id) {
        // Check if ID for doctor exists, or if doctor already is associated
        if( ids.contains(id) && !patientIds.contains(id) ) {
            // Search for doctor with that id
            for( User u : users ) {
                if( u.getID().equals(id) ) {
                    // Add doctor id to list
                    patientIds.add(id);
                    return true;
                }
            }
        }

        // ID does not exist, or doctor is already associated
        return false;
    }

    @Override
    public int hashCode() {
        return docId.hashCode();
    }

    /**
     * ToString method that returns the Doctor data in an organized way
     */
    public String toString(){
        String toString = "First name: " + this.Fname +  "\nLast name: " + this.Lname + "\nUsername: " + this.username
                + "\nDoctor ID: " + this.docId + "\nPhone Number: " + this.phoneNumber + "\nAssociated Patient Ids: \n";
        for( String id : patientIds)
            toString += id + "\n ";
        return toString;
    }
    
}