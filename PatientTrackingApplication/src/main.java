/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GUI_Package.GUI_PatientTrackerStarterPage;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.*;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StarterPageGUIController starterPage = new StarterPageGUIController();
        starterPage.gui.frame.setVisible(true);
    }
}
