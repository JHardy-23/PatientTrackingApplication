import java.util.HashSet;
import java.util.Random;
import java.io.*;

/**
 * The patient class represents patients that go to the docotrs office, each patient
 * will have their own ID and Password which are added to a hashset
 */
public class Patient extends User implements Serializable {
    private String patientId;

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
    }

    /**
     * Constructor for a patient that may be a dependent on an insurance plan
     */
    public Patient(String Fname, String Lname){
        this.Fname = Fname;
        this.Lname = Lname;
        this.patientId = generateId();
    }


    public String getID() {
        return patientId;
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
        return "First name: " + this.Fname +  "\nLast name: " + this.Lname + "\nUsername:" + this.username
         + "\nPatient ID: " + this.patientId + "\nPhone Number: " + this.phoneNumber;
    }

}
