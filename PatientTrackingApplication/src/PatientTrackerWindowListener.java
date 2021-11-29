import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class PatientTrackerWindowListener implements WindowListener {
    public void windowOpened(WindowEvent event) {}
    public abstract void windowClosed(WindowEvent event); // Define in declaration
    public void windowClosing(WindowEvent event) {}
    public void windowIconified(WindowEvent event) {}
    public void windowDeiconified(WindowEvent event) {}
    public void windowActivated(WindowEvent event) {}
    public void windowDeactivated(WindowEvent event) {}
}
