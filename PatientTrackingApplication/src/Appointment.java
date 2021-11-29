import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Arrays;

public class Appointment implements Serializable {
    private LocalDateTime start, end;
    private String patientId, doctorId, details;

    public Appointment(int startHour, int startMinute, int endHour, int endMinute, String date, String doctorId, String patientId) {
        this.start = GetLocalDateTime(startHour, startMinute, date);
        this.end = GetLocalDateTime(endHour, endMinute, date);
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.details = "";
    }

    private LocalDateTime GetLocalDateTime(int h, int m, String d) {
        LocalDateTime ldt;
        LocalTime time;
        LocalDate date;

        // Get time
        time = LocalTime.of(h, m);

        // Get date
        String[] splits = d.split("/");
        int[] intSplits = new int[splits.length];
        for( int i = 0; i < splits.length; i++ ) {
            intSplits[i] = Integer.parseInt(splits[i]);
        }

        // fix if ##/##/## format was put instead of ##/##/####
        if( intSplits[2] < 100 ) {
            intSplits[2] = intSplits[2] + 2000;
        }

        date = LocalDate.of(intSplits[2], intSplits[0], intSplits[1]);

        // Create LocalDateTime
        ldt = LocalDateTime.of(date, time);

        // Return product
        return ldt;
    }

    public LocalDateTime getStartTime() {
        return start;
    }

    public LocalDateTime getEndTime() {
        return end;
    }

    public void setStartTime(LocalDateTime time) {
        this.start = time;
    }

    public void setEndTime(LocalDateTime time) {
        this.end = time;
    }

    public String getPatientName() {
        for( User u : User.users ) {
            if( u.getID().equals(patientId) ) {
                return u.getFirstName() + " " + u.getLname();
            }
        }
        return null;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails( String details ) {
        this.details = details;
    }

    public String getDoctorName() {
        for( User u : User.users ) {
            if( u.getID().equals(doctorId) ) {
                return u.getFirstName() + " " + u.getLname();
            }
        }
        return null;
    }

    public LocalDate getDate() {
        return start.toLocalDate();
    }

    public boolean conflictsWith( Appointment other ) {
        return (start.isBefore(other.start) && end.isAfter(other.start)) || (other.start.isBefore(start) && other.end.isAfter(start));
    }
}
