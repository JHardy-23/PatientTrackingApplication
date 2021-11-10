import java.util.HashSet;
import java.util.Random;

public class Patient {
    private String Fname, Lname, Patientid, Address, emailAdd, Password;
    private char Midinit, sex;
    private Insurance ins;
    public static HashSet<String> patientIds = new HashSet<>();
    public static HashSet<String> patientPass = new HashSet<>();

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

    public String getFname(){
        return this.Fname;
    }

    public void setFname(String newFname){
        this.Fname = newFname;
    }

    public char getMidinit(){
        return this.Midinit;
    }

    public void setMidinit(char newInit){
        this.Midinit = newInit;
    }

    public String getLname(){
        return this.Lname;
    }

    public void setLname(String newLname){
        this.Lname = newLname;
    }

    public String getPatientid(){
        return this.Patientid;
    }

    public char getSex(){
        return this.sex;
    }

    public void setSex(char newSex){
        this.sex = newSex;
    }

    public String getAddress(){
        return this.Address;
    }

    public void setAddress(String newAddress){
        this.Address = newAddress;
    }

    public String getIns(){
        return this.ins.toString();
    }

    public String getEmail(){
        return this.emailAdd;
    }

    public void setEmail(String newEmail){
        this.emailAdd = newEmail;
    }

    public String getPass(){
        return this.Password;
    }

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

    public static boolean checkId(String id){
        if(patientIds.contains(id) || id.charAt(0) == '0'){
            return true;
        }
        return false;
    }

    public String toString(){
        return "First name: " + this.Fname + "\nMiddle Initial: " + this.Midinit + "\nLast name: " + this.Lname
         + "\nPatient ID: " + this.Patientid + "\nSex: " + this.sex + "\nAddress: " + this.Address;
    }

}
