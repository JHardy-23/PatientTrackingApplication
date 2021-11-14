import java.util.HashSet;
import java.util.Random;

/**
 * The patient class represents patients that go to the docotrs office, each patient
 * will have their own ID and Password which are added to a hashset
 */
public class Patient {
    private String Fname, Lname, Patientid, Address, emailAdd, Password;
    private char Midinit, sex;
    private Insurance ins;
    public static HashSet<String> patientIds = new HashSet<>();
    public static HashSet<String> patientPass = new HashSet<>();

    /**
     * Constructor for the patient class
     */
    public Patient(String Fname, char Minit, String Lname, char sex, String Address, Insurance insCov,
    String emailAddress, String password){
        this.Fname = Fname;
        this.Lname = Lname;
        this.Midinit = Minit;
        this.Patientid = generateId();
        this.sex = sex;
        this.Address = Address;
        this.ins = insCov;
        this.Password = password;
        patientPass.add(password);
        this.emailAdd = emailAddress;
    }

    /**
     * Constructor for a patient that may be a dependent on an insurance plan
     */
    public Patient(String Fname, char Minit, String Lname, Insurance insCov){
        this.Fname = Fname;
        this.Midinit = Minit;
        this.Lname = Lname;
        this.ins = insCov;
        this.Patientid = generateId();
    }

    /**
     * Method that returns the First name of the patient
     */
    public String getFname(){
        return this.Fname;
    }

    /**
     * Method that sets the First name of a patient
     */
    public void setFname(String newFname){
        this.Fname = newFname;
    }

    /**
     * Method that returns the middle initial of a patient
     */
    public char getMidinit(){
        return this.Midinit;
    }
    
    /**
     * Method that sets the middle initial of a paitent
     */
    public void setMidinit(char newInit){
        this.Midinit = newInit;
    }

    /**
     * Method that returns the last name of a patient
     */
    public String getLname(){
        return this.Lname;
    }
    /**
     * Method that sets the last name of a patient
     */
    public void setLname(String newLname){
        this.Lname = newLname;
    }

    /**
     * Method that returns the ID of a patient
     */
    public String getPatientid(){
        return this.Patientid;
    }

    /**
     * Method that returns the sex of a patient
     */
    public char getSex(){
        return this.sex;
    }

    /**
     * Method that sets the sex of a patient
     */
    public void setSex(char newSex){
        this.sex = newSex;
    }

    /**
     * Method that returns the address of a patient
     */
    public String getAddress(){
        return this.Address;
    }

    /**
     * Method that sets the address of a patient
     */
    public void setAddress(String newAddress){
        this.Address = newAddress;
    }

    /**
     * Method that returns the toString of a patients insurance
     */
    public String getIns(){
        return this.ins.toString();
    }

    /**
     * Method that returns the email of a patient
     */
    public String getEmail(){
        return this.emailAdd;
    }

    /**
     * Method that sets the email of a patient
     */
    public void setEmail(String newEmail){
        this.emailAdd = newEmail;
    }

    /**
     * Method that returns the password of a patient
     */
    public String getPass(){
        return this.Password;
    }

    /**
     * Method that generates random ID that is length 10 and adds it to a hashset of other IDs
     */
    public static String generateId(){
        Random rand = new Random();
        String idGen = "";
        for(int i = 0; i < 10; i++){
            int newRan = rand.nextInt(10);
            idGen += Integer.toString(newRan);
            if(checkId(idGen) && idGen.length() == 10){
                i = 0;
                idGen = "";
            }
        }
        patientIds.add(idGen);
        return idGen;
    }

    /**
     * Helper method to generateId, it checks if the ID that was generated 
     * already exists or starts with a 0 and if so it tells the generateId method to
     * make another one
     */
    public static boolean checkId(String id){
        if(patientIds.contains(id) || id.charAt(0) == '0'){
            return true;
        }
        return false;
    }

    /**
     * Method that returns a string about the patient object in an 
     * organized fashion
     */
    public String toString(){
        return "First name: " + this.Fname + "\nMiddle Initial: " + this.Midinit + "\nLast name: " + this.Lname
         + "\nPatient ID: " + this.Patientid + "\nSex: " + this.sex + "\nAddress: " + this.Address;
    }

}
