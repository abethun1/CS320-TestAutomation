import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Toni
 */
public class TaskTest {

    /**
     * Test of class object creation
     */
    @Test
    public void testTaskClass() {
        Task run = new Task ("0", "Run", "Do a 5 mile run");
        assertTrue(run.getID().equals("0"));
        assertTrue(run.getName().equals("Run"));
        assertTrue(run.getDescription().equals("Do a 5 mile run"));
    }
    
    @Test
    public void testIllegalArgumentsForTaskClass(){
        
        //Test to make sure exception is thrown if ID is null or has too many chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task ("1234567891011", "Run", "Do a 5 mile run");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task (null, "Run", "Do a 5 mile run");
        });
        
        //Test to make sure exception is thrown if name of task is null or has too many chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task ("0", "Running a maraton may be fun for the first few miles but could.......", "Do a 5 mile run");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task ("0", null, "Do a 5 mile run");
        });
        
        //Test to make sure exception is thrown if description of task is null or has too many chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task ("0", "Run", "Do a 5 mile run. "
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
            new Task ("0", "Run", null);
        });
    }
    
}
