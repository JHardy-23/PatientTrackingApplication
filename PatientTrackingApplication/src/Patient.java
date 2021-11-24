import java.util.HashSet;
import java.util.Random;

/**
 * The patient class represents patients that go to the docotrs office, each patient
 * will have their own ID and Password which are added to a hashset
 */
public class Patient {
    private String firstName, lastName, Patientid, emailAdd, Password, Username, phoneNumber;
    private Insurance ins;
    public static HashSet<String> patientIds = new HashSet<>();
    public static HashSet<String> patientPass = new HashSet<>();

    /**
     * Constructor for the patient class
     */
    public Patient(String Fname, String Lname, String Uname, String pNumber, Insurance insCov, String emailAddress, String password){
        this.firstName = Fname;
        this.lastName = Lname;
        this.Patientid = generateId();
        this.ins = insCov;
        this.Username = Uname;
        this.phoneNumber = pNumber;
        this.Password = password;
        patientPass.add(password);
        this.emailAdd = emailAddress;
    }

    /**
     * Constructor for a patient that may be a dependent on an insurance plan
     */
    public Patient(String Fname, String Lname, Insurance insCov){
        this.firstName = Fname;
        this.lastName = Lname;
        this.ins = insCov;
        this.Patientid = generateId();
    }

    /**
     * Method that returns the First name of the patient
     */
    public String getFname(){
        return this.firstName;
    }

    /**
     * Method that sets the First name of a patient
     */
    public void setFname(String newFname){
        this.firstName = newFname;
    }

    /**
     * Method that returns the middle initial of a patient
     */
    public String getPhonenumber(){
        return this.phoneNumber;
    }
    
    /**
     * Method that sets the middle initial of a paitent
     */
    public void setPhoneNumber(String newPnumber){
        this.phoneNumber = newPnumber;
    }

    /**
     * Method that returns the last name of a patient
     */
    public String getLname(){
        return this.lastName;
    }
    /**
     * Method that sets the last name of a patient
     */
    public void setLname(String newLname){
        this.lastName = newLname;
    }

    /**
     * Method that returns the ID of a patient
     */
    public String getPatientid(){
        return this.Patientid;
    }
    /**
     * Method that returns the address of a patient
     */
    public String getUsername(){
        return this.Username;
    }

    /**
     * Method that sets the address of a patient
     */
    public void setUsername(String newUsername){
        this.Username = newUsername;
    }

    /**
     * Method that returns the toString of a patients insurance
     */
    public String getIns(){
        return this.ins.toString();
    }


    /**
     * Method that sets the insurance of a patient
     */
    public void setIns(Insurance newIns){
        this.ins = newIns;
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
        return patientIds.contains(id) || id.charAt(0) == '0';
    }

    /**
     * Method that returns a string about the patient object in an 
     * organized fashion
     */
    public String toString(){
        return "First name: " + this.firstName +  "\nLast name: " + this.lastName + "\nUsername:" + this.Username
         + "\nPatient ID: " + this.Patientid + "\nPhone Number: " + this.phoneNumber + "\nInsurance Provider: " + this.ins.getInsuranceName();
    }

}
