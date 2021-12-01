import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class PatientInformationGUIController{
    public GUI_Package.GUI_PatientInformationPage gui;
    private Patient account;

    public PatientInformationGUIController(Patient account){
        gui = new GUI_Package.GUI_PatientInformationPage();
        this.account = account;
        updatefName(account.getFirstName());
        updatelName(account.getLname());
        updateDOB(account.getDateOfBirth());
        updateMedhist(account.getMedicalHistory());
        

        gui.getButton("Click here for Doctors").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String doctorNames = "";
                for(String id: account.getDoctorIds()){
                    for( User u : User.users ) {
                        if(u.getID().equals(id)) {
                            doctorNames += "• Dr. " + u.getFirstName() + " " + u.getLname() + "\n";
                        }
                    }
                }
                JOptionPane.showMessageDialog(gui.frame, doctorNames, "Doctors", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        gui.getButton("Edit").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Object[] options = {"First name", "Last name", "Medical History", "DOB"};
                int choice = JOptionPane.showOptionDialog(gui.frame, "What would you like to edit?", "Edit Information", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[3]);
                switch(choice){
                    case 0:
                        String x = (String)JOptionPane.showInputDialog(gui.frame, "Please input your new first name: ", 
                        "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
                        account.Fname = x;
                        updatefName(x);
                        break;
                    case 1:
                        String y = (String)JOptionPane.showInputDialog(gui.frame, "Please input your new last name: ", 
                        "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
                        account.Lname = y;
                        updatelName(y);
                        break;
                    case 2:
                        gui.textArea.setEditable(true);
                        String z = (String)JOptionPane.showInputDialog(gui.frame, "Please Update your medical record (This will delete everything else): ", 
                        "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
                        account.setMedicalHistory(z);
                        updateMedhist(z);
                        gui.textArea.setEditable(false);
                        break;
                    case 3:
                            String date = (String)JOptionPane.showInputDialog(gui.frame, "Please enter your date of birth\n Must be in the format MM/DD/YYYY", 
                            "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
                            int month, day, year;
                            try{
                                month = Integer.valueOf(date.substring(0,2));
                                day = Integer.valueOf(date.substring(3, 5));
                                year = Integer.valueOf(date.substring(6, date.length()));
                            }
                            catch(Exception q){
                                JOptionPane.showInputDialog(gui.frame, "The date you entered was invalid please try again\n Must be in the format MM/DD/YYYY", 
                                "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
                                break;
                            }

                            while(true){
                                if(date.length() == 10 && date.charAt(2) == '/' && date.charAt(5) == '/' && day > 0 && day < 32 && month > 0 && month < 13 && year > 1899 && year < 2022){
                                    updateDOB(date);
                                    account.setDateOfBirth(date);
                                    break;
                                }
                                else{
                                    date = (String)JOptionPane.showInputDialog(gui.frame, "The date you entered was invalid please try again\n Must be in the format MM/DD/YYYY", 
                                    "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
                                }
                            }
                            break;
                }
            }
        });  
    }

    public void updatefName(String fname){
        gui.firstNameTextField.setText(account.getFirstName());
        WriteChangesToFile();
    }

    public void updatelName(String lname){
        gui.lastNameTextField.setText(account.getLname());
        WriteChangesToFile();
    }

    public void updateMedhist(String hist){
        gui.textArea.setText(hist);
        WriteChangesToFile();
    }

    public void updateDOB(String newDOB){
        gui.DOBTextField.setText(newDOB);
        WriteChangesToFile();
    }

    private void WriteChangesToFile() {
        try {
            User.WriteSetToUserFile();
        }
        catch(Exception e) {
            System.out.println("ERROR writing changes to users file.");
        }
    }
}