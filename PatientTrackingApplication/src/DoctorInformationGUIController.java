import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class DoctorInformationGUIController{
    public GUI_Package.GUI_DoctorInformationPage gui;
    private Doctor account;

    public DoctorInformationGUIController(Doctor account){
        gui = new GUI_Package.GUI_DoctorInformationPage();
        this.account = account;
        updatefName(account.Fname);
        updatelName(account.Lname);
        if(account.getPrefix().length() > 0){
            updatePrefix(account.getPrefix());
        }
        if(account.getEdu().length() > 0){
            updateEdu(account.getEdu());
        }
        if(account.getProfession().length() > 0){
            updateProfession(account.getProfession());
        }

        gui.getButton("Click here for Patients").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String patientNames = "";
                for(String id: account.getPatientIds()){
                    for(User u: User.users){
                        if(u.getID().equals(id)){
                            patientNames += "•\t" + u.getFirstName() + " " + u.getLname() + "\n";
                        }
                    }
                }
                JOptionPane.showMessageDialog(gui.frame, patientNames, "Patients", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        gui.getButton("Edit").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Object[] options = {"Suffix", "First Name", "Last Name", "Profession", "Education"};
                int choice = JOptionPane.showOptionDialog(gui.frame, "What would you like to edit?", "Edit Information", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[4]);
                switch(choice){
                    case 0:
                        Object[] possibilities = {"Mr", "Ms", "Mrs", "Mx"};
                        String s = (String)JOptionPane.showInputDialog(gui.frame, "Please choose your preferred prefix:",
                        "Prefix Selection", JOptionPane.PLAIN_MESSAGE,null,possibilities, null);
                        updatePrefix(s);
                        break;
                    case 1:
                        String x = (String)JOptionPane.showInputDialog(gui.frame, "Please input your new first name: ", 
                        "First Name Edit", JOptionPane.PLAIN_MESSAGE, null, null, null);
                        account.Fname = x;
                        updatefName(x);
                        break;
                    case 2:
                        String y = (String)JOptionPane.showInputDialog(gui.frame, "Please input your new last name: ", 
                        "Last Name Edit", JOptionPane.PLAIN_MESSAGE, null, null, null);
                        account.Lname = y;
                        updatelName(y);
                        break;
                    case 3:
                        Object[] possibilities2 = {"Family Physician", "Internal Medicine Physician", "Pediatrician", "OBGYN", "Cardiologist",
                        "Oncologist", "Gastreonterologist", "Pulmonologist", "Nephrologist", "Surgeon", "Other"};
                        String q = (String)JOptionPane.showInputDialog(gui.frame, "Please choose your preferred prefix:",
                        "Prefix Selection", JOptionPane.PLAIN_MESSAGE,null,possibilities2, null);
                        if(q.equalsIgnoreCase("other")){
                            String profession = (String)JOptionPane.showInputDialog(gui.frame, "Please input you profession: ", 
                            "Profession Edit", JOptionPane.PLAIN_MESSAGE, null, null, null);
                            updateProfession(profession);
                        }
                        else{
                            updateProfession(q);
                        }
                        break;
                    case 4:
                        gui.textArea.setEditable(true);
                        String z = (String)JOptionPane.showInputDialog(gui.frame, "Please Update your Education (This will delete everything else): ", 
                        "Update Education", JOptionPane.PLAIN_MESSAGE, null, null, null);
                        updateEdu(z);
                        gui.textArea.setEditable(false);
                        break;
                }
            }   
        });

    }

    public void updatePrefix(String newprefix){
        gui.suffixTextField.setText(newprefix);
        account.setPrefix(newprefix);
    }

    public void updatefName(String fname){
        gui.firstNametectField.setText(account.getFirstName());
        WriteChangesToFile();
    }

    public void updatelName(String lname){
        gui.lastNameTextField.setText(account.getLname());
        WriteChangesToFile();
    }

    public void updateProfession(String newProf){
        gui.professionTextField.setText(newProf);
        account.setProfession(newProf);
    }

    public void updateEdu(String Edu){
        gui.textArea.setText(Edu);
        account.setEduHis(Edu);
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

