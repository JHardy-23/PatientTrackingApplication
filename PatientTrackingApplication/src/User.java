import java.util.HashSet;
import java.util.Random;
import java.io.*;

public abstract class User implements Serializable {
    protected String Fname, Lname, Address, emailAddress, phoneNumber, username, Password;
    public static HashSet<User> users = new HashSet<User>();
    private static final String patientsFileName = "patients.ser", doctorsFileName = "doctors.ser";

    /**
     * Read users from file to update users HashSet
     */
    public static void ReadSetFromUserFile() throws IOException, ClassNotFoundException {
        // Reset HashSet
        users = new HashSet<User>();

        // Check if file exists
        File file = new File(patientsFileName);
        if( file.exists() ) {
            // Open input streams
            FileInputStream pInput = new FileInputStream(file);
            ObjectInputStream pOInput = new ObjectInputStream(pInput);
            FileInputStream dInput = new FileInputStream(file);
            ObjectInputStream dOInput = new ObjectInputStream(dInput);

            // Read from Patient input file
            while(true) {
                Object oUser = pOInput.readObject();
                if( oUser == null )
                    break;
                users.add((Patient)oUser);
            }

            // Read from Doctor input file
            while(true) {
                Object oUser = dOInput.readObject();
                if( oUser == null )
                    break;
                users.add((Doctor)oUser);
            }

            // Close file streams
            pOInput.close();
            pInput.close();

            dOInput.close();
            dInput.close();

            // Print debug message
            System.out.println("Serialized Data was read from file " + patientsFileName);
            System.out.println("HashSet:\n");
            for(User u : users) {
                System.out.println(u);
            }
        }
    }

    /**
     * Read users from file to update users HashSet
     */
    public static void WriteSetToUserFile() throws IOException {
        // Open output streams
        FileOutputStream pOutput = new FileOutputStream(patientsFileName);
        ObjectOutputStream pOOutput = new ObjectOutputStream(pOutput);
        FileOutputStream dOutput = new FileOutputStream(doctorsFileName);
        ObjectOutputStream dOOutput = new ObjectOutputStream(pOutput);

        // Convert HashSet to array
        Object[] usersArray = users.toArray();

        // Write users HashSet to output file
        for( Object user : usersArray ) {
            if( user instanceof Patient ) {
                pOOutput.writeObject(user);
            }
            else {
                dOOutput.writeObject(user);
            }
        }
        // Write null to end as a sign that it is the end of the list
        pOOutput.writeObject(null);
        dOOutput.writeObject(null);

        // Close file streams
        pOOutput.close();
        dOOutput.close();

        pOutput.close();
        dOutput.close();

        // Print debug message
        System.out.println("Serialized Data is saved in files " + patientsFileName + " and " + doctorsFileName);
    }

    /**
     * Read users from file to update users HashSet
     */
    public static boolean AddUser( User user ) {
        return users.add(user);
    }

    /**
     * Method that returns the first name of a User
     */
    public String getFirstName(){
        return this.Fname;
    }

    /**
     * Method that sets the first name of a User
     */
    public void setFname(String newF){
        this.Fname = newF;
    }

    /**
     * Method that returns the last name of a User
     */
    public String getLname(){
        return this.Lname;
    }

    /**
     * Method that sets the last name of a User
     */
    public void setLname(String newL){
        this.Lname = newL;
    }

    /**
     * Method that returns the middle initial of a User
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Method that sets the middle initial of a User
     */
    public void setUsername(String newUname){
        this.username = newUname;
    }

    /**
     * Method that returns the Address of a User
     */
    public String getAddress(){
        return this.Address;
    }

    /**
     Method that sets the address of a User
     */
    public void setAddress(String newAdd){
        this.Address = newAdd;
    }

    /**
     * Method that returns the sex of a User
     */
    public String getpNumber(){
        return this.phoneNumber;
    }

    /**
     * Method that sets the sex of a User
     */
    public void setPnumber(String newPnumber){
        this.phoneNumber = newPnumber;
    }

    /**
     * Method that returns the email of a User
     */
    public String getEmail(){
        return this.emailAddress;
    }

    /**
     * Method that sets the email of a User
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
}
