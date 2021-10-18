import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.time.LocalDate;

/**
 *
 * @author Toni
 */
public class AppointmentTest {
    
    /**
     * Test of class object creation
     */
    @Test
    public void testAppointmentClass() {
    	LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        
        Appointment run = new Appointment ("0", tomorrow, "Do a 5 mile run");
        assertTrue(run.getID().equals("0"));
        assertTrue(run.getDate().equals(tomorrow));
        assertTrue(run.getDescription().equals("Do a 5 mile run"));
    }
    
    @Test
    public void testIllegalArgumentsForAppointmentClass(){
        
        //Test to make sure exception is thrown if ID is null or has too many chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment ("1234567891011", LocalDate.now(), "Do a 5 mile run");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment (null, LocalDate.now(), "Do a 5 mile run");
        });
        
        //Test to make sure exception is thrown if name of Appointment is null or has too many chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment ("0", null, "Do a 5 mile run");
        });
        
        //Test to make sure exception is thrown if description of Appointment is null or has too many chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment ("0", LocalDate.now(), "Do a 5 mile run. "
                    + "Running a maraton may be fun for the first few miles but could"
                    + ".......Running a maraton may be fun for the first few miles but could"
                    + ".......Running a maraton may be fun for the first few miles but could"
                    + ".......Running a maraton may be fun for the first few miles but could"
                    + ".......Running a maraton may be fun for the first few miles but could"
                    + ".......Running a maraton may be fun for the first few miles but could"
                    + ".......Running a maraton may be fun for the first few miles but could"
                    + ".......Running a maraton may be fun for the first few miles but could"
                    + ".......Running a maraton may be fun for the first few miles but could"
                    + ".......");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment ("0", LocalDate.now(), null);
        });
    }
    
}
