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
public class AppointmentServiceTest {
    
    Calendar calendar = Calendar.getInstance();
    LocalDate today = LocalDate.now();

        
    AppointmentService myAppointments = new AppointmentService();
        
    Appointment Run = new Appointment("0", today , "Go for a 3 mile run.");
    Appointment Homework = new Appointment("1", today, "Do your CS homework.");

    /**
     * Test of getAppointmentByID method, of class AppointmentServices.
     */
        
    //These test make sure that Appointment can be succesfully retrieved from the AppointmentService Object by ID
    
    @Test
    public void testGetAppointmentByID() {
        myAppointments.addAppointment(Run);
        
        assertTrue(myAppointments.getAppointmentByID("0").equals(Run));
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myAppointments.getAppointmentByID("6");
        });
    }

    /**
     * Test of addAppointment method, of class AppointmentServices.
     */
    
    //These test make sure that Appointment can be succesfully added to the AppointmentService Object
    @Test
    public void testAddAppointment() {
        assertTrue(myAppointments.getSize() == 0);
        
        myAppointments.addAppointment(Run);
        myAppointments.addAppointment(Homework);
        
        assertTrue(myAppointments.getSize() == 2);
    }

    /**
     * Test of deleteContact method, of class AppointmentServices.
     */
    
    //These test make sure that a Appointment can be deleted from the AppointmentService Object
    @Test
    public void testDeleteAppointment() {
        myAppointments.addAppointment(Run);
        myAppointments.addAppointment(Homework);
        
        assertTrue(myAppointments.getSize() == 2);
        
        myAppointments.deleteAppointment("0");
        
        assertTrue(myAppointments.getSize() == 1);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myAppointments.deleteAppointment("6");
        });
        
    }
}
