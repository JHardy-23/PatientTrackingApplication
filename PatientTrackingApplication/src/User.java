import java.util.ArrayList;
import java.util.HashSet;
import java.io.*;
import java.util.Random;

public abstract class User implements Serializable {
    protected String Fname, Lname, Address, emailAddress, phoneNumber, username, Password;
    protected ArrayList<Appointment> appointments;
    public static HashSet<User> users = new HashSet<User>();
    public static HashSet<String> ids = new HashSet<String>();
    private static final String UsersFileName = "users.ser";

    /**
     * Read users from file to update users HashSet
     */
    public static void ReadSetFromUserFile() throws IOException, ClassNotFoundException {
        // Reset HashSet
        users.clear();

        // Check if file exists
        File file = new File(UsersFileName);
        if( file.exists() ) {
            // Open input streams
            FileInputStream pInput = new FileInputStream(file);
            ObjectInputStream pOInput = new ObjectInputStream(pInput);

            // Read from HashSet input file
            users = (HashSet<User>)pOInput.readObject();
            ids = (HashSet<String>)pOInput.readObject();

            // Close file streams
            pOInput.close();
            pInput.close();

            // Print debug message
            System.out.println("Serialized Data was read from file " + UsersFileName);
            System.out.println("HashSet:\n");
            System.out.println("users HashSet:\n");
            for(User u : users) {
                System.out.println(u + "\n");
            }
            System.out.println("ids HashSet:\n");
            for(String id : ids) {
                System.out.println(id + "\n");
            }
        }
    }

    /**
     * Read users from file to update users HashSet
     */
    public static void WriteSetToUserFile() throws IOException {
        // Open output streams
        FileOutputStream pOutput = new FileOutputStream(UsersFileName);
        ObjectOutputStream pOOutput = new ObjectOutputStream(pOutput);

        // Write users HashSet to output file
        pOOutput.writeObject(users);
        pOOutput.writeObject(ids);

        // Close file streams
        pOOutput.close();
        pOutput.close();

        // Print debug message
        System.out.println("Serialized Data is saved in file " + UsersFileName + ".");
        System.out.println("HashSet:\n");
        System.out.println("users HashSet:\n");
        for(User u : users) {
            System.out.println(u + "\n");
        }
        System.out.println("ids HashSet:\n");
        for(String id : ids) {
            System.out.println(id + "\n");
        }
    }

    /**
     * Read users from file to update users HashSet
     */
    public static boolean AddUser( User user ) {
        return users.add(user) && ids.add(user.getID());
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
            if(checkId(idGen, false) && idGen.length() == 12){
                i = 0;
                idGen = "";
            }
        }
        return idGen;
    }

    /**
     * Helper function for generate ID, checks that the hashset doesn't contain
     * a newly generated doctor's ID and that it doesn't start with zero.
     * Returns true if the ID is not valid, and false if it is.
     */
    public static boolean checkId(String id, boolean isDoctor){
        return ids.contains(id) || (id.charAt(0) == '0' && !isDoctor) || (id.charAt(0) != '0' && isDoctor) || id.length() != 12;
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

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public boolean addAppointment( Appointment a ) {
        if( !appointments.contains(a) ) {
            appointments.add(a);
            return true;
        }
        return false;
    }

    /**
     * Method that sets the email of a User
     */
    public void setEmail(String newEmail){
        this.emailAddress = newEmail;
    }

    public abstract String getID();

    /**
     *Method that returns the password of a doctor
     */
    public String getPass(){
        return this.Password;
    }

    @Override
    public abstract int hashCode();
}
