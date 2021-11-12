import java.util.ArrayList;

/**
 * The Insurance class which will represent what type of insurance a patient has
 */
public class Insurance{
    private String insName, insId, grpNum;
    private ArrayList<Patient> individualsCovered;

    /**
     * The constructor for the Insurance class
     */
    public Insurance(String name, String Id, String grpNumber, ArrayList<Patient> Covered){
        this.insName = name;
        this.insId = Id;
        this.grpNum = grpNumber;
        this.individualsCovered = Covered;
    }

    /**
     * Method that returns the name of the Insurance
     */
    public String getInsuranceName(){
        return this.insName;
    }

    /**
     * Method that sets the name of the insurance
     */
    public void setInsName(String newName){
        this.insName = newName;
    }

    /**
     * Method that returns the Insurance ID
     */
    public String getId(){
        return this.insId;
    }

    /**
     * Method that sets the insurance ID
     */
    public void setId(String newId){
        this.insId = newId;
    }

    /**
     * Method that returns the Insurance Group Number
     */
    public String getGrpNum(){
        return this.grpNum;
    }

    /**
     * Method that sets the Insurance's Group Number
     */
    public void setGrpNum(String newGrp){
        this.grpNum = newGrp;
    }

    /**
     * Method that gets the individuals covered by an insurance plan, returns all 
     * covered that are contained in ArrayLists
     */
    public String getCovered(){
        String covered = "";
        for(int i = 0; i < this.individualsCovered.size(); i++){
            covered = covered + this.individualsCovered.get(i)+ ", ";
        }
        return covered;
    }

    /**
     * Method that adds a new patient that is covered to the array list
     */
    public void addCovered(Patient newCov){
        this.individualsCovered.add(newCov);
    }

    /**
     * Method that delets a patient from the insurance plan in the array list
     */
    public void deleteCovered(Patient delCov){
        this.individualsCovered.remove(delCov);
    }

    /**
     * ToString method that returns a string of the insurance object in an organized fashion
     */
    public String toString(){
        return "\nInsurance name: " + this.insName + "\nInsurance ID: " + this.insId + "\nGroup Number: "
        + this.grpNum;
    }
}