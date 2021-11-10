import java.util.ArrayList;

public class Insurance{
    private String insName, insId, grpNum;
    private ArrayList<String> individualsCovered;

    public Insurance(String name, String Id, String grpNumber, ArrayList<String> Covered){
        this.insName = name;
        this.insId = Id;
        this.grpNum = grpNumber;
        this.individualsCovered = Covered;
    }

    public String getInsuranceName(){
        return this.insName;
    }

    public void setInsName(String newName){
        this.insName = newName;
    }

    public String getId(){
        return this.insId;
    }

    public void setId(String newId){
        this.insId = newId;
    }

    public String getGrpNum(){
        return this.grpNum;
    }

    public void setGrpNum(String newGrp){
        this.grpNum = newGrp;
    }

    public String getCovered(){
        String covered = "";
        for(int i = 0; i < this.individualsCovered.size(); i++){
            covered = covered + this.individualsCovered.get(i)+ ", ";
        }
        return covered;
    }

    public void addCovered(String newCov){
        this.individualsCovered.add(newCov);
    }

    public void deleteCovered(String delCov){
        this.individualsCovered.remove(delCov);
    }

    public String toString(){
        return "\nInsurance name: " + this.insName + "\nInsurance ID: " + this.insId + "\nGroup Number: "
        + this.grpNum;
    }
}