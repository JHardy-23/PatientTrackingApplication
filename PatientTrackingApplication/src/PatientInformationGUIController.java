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
        gui.firstNameTextField.setText(account.getFirstName());
        gui.lastNameTextField.setText(account.getLname());

        gui.getButton("Click here for Doctors").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String docIDs = "";
                for(String id: account.getDoctorIds()){
                    docIDs += id + "\n";
                }
                JOptionPane.showMessageDialog(gui.frame, docIDs, "Doctor IDs", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}