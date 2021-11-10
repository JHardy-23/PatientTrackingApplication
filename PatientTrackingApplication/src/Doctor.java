import java.util.HashSet;
import java.util.Random;

public class Doctor{
    private String Fname, Lname, docId, Address;
    private char Midinit, sex;
    public static HashSet<String> doctorIds = new HashSet<>();

    public Doctor(String First, char mid, String Last, String Add, char sx){
        this.Fname = First;
        this.Midinit = mid;
        this.Lname = Last;
        this.docId = generateId();
        this.Address = Add;
        this.sex = sx;
    }

    public String getFirstName(){
        return this.Fname;
    }

    public void setFname(String newF){
        this.Fname = newF;
    }

    public String getLname(){
        return this.Lname;
    }

    public void setLname(String newL){
        this.Lname = newL;
    }

    public char getMidinit(){
        return this.Midinit;
    }

    public void setMidinit(char newM){
        this.Midinit = newM;
    }

    public String getdocId(){
        return this.docId;
    }

    public String getAddress(){
        return this.Address;
    }

    public void setAddress(String newAdd){
        this.Address = newAdd;
    }

    public char getSex(){
        return this.sex;
    }

    public void setSex(char newSex){
        this.sex = newSex;
    }

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

    public static boolean checkId(String id){
        if(doctorIds.contains(id) || id.charAt(0) == '0'){
            return true;
        }
        return false;
    }

    public String toString(){
        return "\nFirst name: " + this.Fname + "\nMiddle Initial: " + this.Midinit + "\nLast name: " + this.Lname
        + "\nAddress: " + this.Address + "\nSex: " + this.sex;
    }
    
}