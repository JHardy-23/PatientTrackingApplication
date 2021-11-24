import java.util.HashSet;
import java.util.Random;
import java.io.*;

/**
 * The Doctor class represents doctors that work at the establishment, each doctor will have their
 * own ID and password which are checked using a hashset.
 */

public class Doctor extends User implements Serializable {
    private String docId;
    public static HashSet<String> doctorIds = new HashSet<>();
    public static HashSet<String> docPass = new HashSet<>();

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
        docPass.add(Pass);
    }

    /**
     * Method that returns the first name of a doctor
     */
    public String getFirstName(){
        return this.Fname;
    }

    /**
     * Method that sets the first name of a doctor
     */
    public void setFname(String newF){
        this.Fname = newF;
    }

    /**
     * Method that returns the last name of a doctor
     */
    public String getLname(){
        return this.Lname;
    }

    /**
     * Method that sets the last name of a doctor
     */
    public void setLname(String newL){
        this.Lname = newL;
    }

    /**
     * Method that returns the middle initial of a doctor
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Method that sets the middle initial of a doctor
     */
    public void setUsername(String newUname){
        this.username = newUname;
    }

    /**
     * Method that returns the ID of a doctor
     */
    public String getdocId(){
        return this.docId;
    }

    /** 
     * Method that returns the sex of a doctor
     */
    public String getpNumber(){
        return this.phoneNumber;
    }

    /**
     * Method that sets the sex of a doctor
     */
    public void setPnumber(String newPnumber){
        this.phoneNumber = newPnumber;
    }

    /**
     * Method that returns the email of a doctor
     */
    public String getEmail(){
        return this.emailAddress;
    }

    /**
     * Method that sets the email of a doctor
     */
    public void setEmail(String newEmail){
        this.emailAddress = newEmail;
    }

    /**
     *Method that returns the password of a doctor
     */
    public String getPass(){
        return this.Password;
    }

    /**
     * Method that generates a random string that is a length of 10,
     * is all integers, doesn't start with the integer zero and doesn't
     * already exist
     */
    public static String generateId(){
        Random rand = new Random();
        String idGen = "";
        for(int i = 0; i < 12; i++){
            int newRan = rand.nextInt(10);
            idGen += Integer.toString(newRan);
            if(checkId(idGen) && idGen.length() == 12){
                i = 0;
                idGen = "";
            }
        }
        doctorIds.add(idGen);
        return idGen;
    }

    /**
     * Helper function for generate ID, checks that the hashset doesn't contain
     * a newly generated doctor's ID and that it doens't start with zero
     */
    public static boolean checkId(String id){
        if(doctorIds.contains(id) || id.charAt(0) == '0'){
            return true;
        }
        return false;
    }

    /**
     * ToString method that returns the Doctor data in an organized way
     */
    public String toString(){
        return "\nFirst name: " + this.Fname + "\nLast name: " + this.Lname + "\nUsername: " + this.username +
        "\nPhone Number: " + this.phoneNumber;
    }
    
}