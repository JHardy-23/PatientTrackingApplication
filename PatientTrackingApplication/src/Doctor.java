import java.util.HashSet;
import java.util.Random;

/**
 * The Doctor class represents doctors that work at the establishment, each doctor will have their
 * own ID and password which are checked using a hashset.
 */

public class Doctor{
    private String Fname, Lname, docId, Address, emailAddress, Password;
    private char Midinit, sex;
    public static HashSet<String> doctorIds = new HashSet<>();
    public static HashSet<String> docPass = new HashSet<>();

    /**
     * Constructor for the Doctor object
     */
    public Doctor(String First, char mid, String Last, String Add, char sx, String emailAdd, String Pass){
        this.Fname = First;
        this.Midinit = mid;
        this.Lname = Last;
        this.docId = generateId();
        this.Address = Add;
        this.sex = sx;
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
    public char getMidinit(){
        return this.Midinit;
    }

    /**
     * Method that sets the middle initial of a doctor
     */
    public void setMidinit(char newM){
        this.Midinit = newM;
    }

    /**
     * Method that returns the ID of a doctor
     */
    public String getdocId(){
        return this.docId;
    }

    /**
     * Method that returns the Address of a doctor
     */
    public String getAddress(){
        return this.Address;
    }

    /**
    Method that sets the address of a doctor
     */
    public void setAddress(String newAdd){
        this.Address = newAdd;
    }

    /** 
     * Method that returns the sex of a doctor
     */
    public char getSex(){
        return this.sex;
    }

    /**
     * Method that sets the sex of a doctor
     */
    public void setSex(char newSex){
        this.sex = newSex;
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
        return "\nFirst name: " + this.Fname + "\nMiddle Initial: " + this.Midinit + "\nLast name: " + this.Lname
        + "\nAddress: " + this.Address + "\nSex: " + this.sex;
    }
    
}