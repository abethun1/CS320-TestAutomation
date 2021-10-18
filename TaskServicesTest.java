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
public class TaskServicesTest {
        TaskServices myTasks = new TaskServices();
        
        Task Run = new Task("0", "Run", "Go for a 3 mile run.");
        Task Homework = new Task("1", "Do Homework", "Do your CS homework.");
        
    /**
     * Test of getTaskByID method, of class TaskServices.
     */
        
    //These test make sure that Task can be succesfully retrieved from the TaskService Object by ID
    
    @Test
    public void testGetTaskByID() {
        myTasks.addTask(Run);
        
        assertTrue(myTasks.getTaskByID("0").equals(Run));
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myTasks.getTaskByID("6");
        });
    }

    /**
     * Test of addTask method, of class TaskServices.
     */
    
    //These test make sure that Task can be succesfully added to the TaskService Object
    @Test
    public void testAddTask() {
        assertTrue(myTasks.getSize() == 0);
        
        myTasks.addTask(Run);
        myTasks.addTask(Homework);
        
        assertTrue(myTasks.getSize() == 2);
    }

    /**
     * Test of deleteContact method, of class TaskServices.
     */
    
    //These test make sure that a Task can be deleted from the TaskService Object
    @Test
    public void testDeleteContact() {
        myTasks.addTask(Run);
        myTasks.addTask(Homework);
        
        assertTrue(myTasks.getSize() == 2);
        
        myTasks.deleteTask("0");
        
        assertTrue(myTasks.getSize() == 1);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myTasks.deleteTask("6");
        });
        
    }



    @Test
    public void testUpdateTaskName() {
        myTasks.addTask(Run);
        myTasks.addTask(Homework);
        
        assertTrue(myTasks.getTaskByID("1").getName().equals("Do Homework"));
        
        myTasks.updateTaskName("1", "Finish Homework");
        
        assertTrue(myTasks.getTaskByID("1").getName().equals("Finish Homework"));
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myTasks.updateTaskName("1", "This is now an invalid name because the string is much longer than what is suppose to be");
        });
    }


    /**
     * Test of updateTaskDescription method, of class TaskServices.
     */
    @Test
    public void testUpdateTaskDescription() {
        myTasks.addTask(Run);
        myTasks.addTask(Homework);
        
        assertTrue(myTasks.getTaskByID("1").getDescription().equals("Do your CS homework."));
        
        myTasks.updateTaskDescription("1", "Go and do your CS Homework");
        
        assertTrue(myTasks.getTaskByID("1").getDescription().equals("Go and do your CS Homework"));
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myTasks.updateTaskDescription("0", "This is now an invalid name because the string is much longer than what is suppose to be..."
                    + "This is now an invalid name because the string is much longer than what is suppose to be...."
                    + "This is now an invalid name because the string is much longer than what is suppose to be...."
                    + "This is now an invalid name because the string is much longer than what is suppose to be."
                    + "This is now an invalid name because the string is much longer than what is suppose to be..."
                    + "This is now an invalid name because the string is much longer than what is suppose to be..."
                    + "This is now an invalid name because the string is much longer than what is suppose to be"
                    + "This is now an invalid name because the string is much longer than what is suppose to be");
        });
    }
    
}
