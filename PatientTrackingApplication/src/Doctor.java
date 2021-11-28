import java.util.HashSet;
import java.util.Random;
import java.io.*;

/**
 * The Doctor class represents doctors that work at the establishment, each doctor will have their
 * own ID and password which are checked using a hashset.
 */

public class Doctor extends User implements Serializable {
    private String docId;

    /**
     * Constructor for the Doctor object
     */
    public Doctor(String First, String Last, String uName, String emailAdd, String Pass, String pNumber){
        this.Fname = First;
        this.Lname = Last;
        this.username = uName;
        this.docId = generateId();
        this.phoneNumber = pNumber;
        this.emailAddress = emailAdd;
        this.Password = Pass;
    }

    public String getID() {
        return docId;
    }

    @Override
    public int hashCode() {
        return docId.hashCode();
    }

    /**
     * ToString method that returns the Doctor data in an organized way
     */
    public String toString(){
        return "First name: " + this.Fname +  "\nLast name: " + this.Lname + "\nUsername:" + this.username
                + "\nDoctor ID: " + this.docId + "\nPhone Number: " + this.phoneNumber;
    }
    
}