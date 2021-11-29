/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * FXML Controller class
 *
 * @author cmn68
 */
public class DoctorHomepageGUIController {
    public GUI_Package.GUI_DoctorHomepage gui;
    private Doctor account;

    public DoctorHomepageGUIController(Doctor account) {
        gui = new GUI_Package.GUI_DoctorHomepage();
        this.account = account;
        gui.getButton("Sign Out").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.frame.dispose();
            }
        });
    }
}
