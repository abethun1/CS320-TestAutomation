import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;


import org.junit.Test;

public class ContactTest {

    @Test
    public void testContactClass(){
    	//Test the successful creation of a Contact Object
        Contact Toni = new Contact("0", "Antonio", "Bethune", "5165578255", "219 Gertrude");
        assertTrue(Toni.getFirstName().equals("Antonio"));
        assertTrue(Toni.getID().equals("0")&& Toni.getID() != null);
        assertTrue(Toni.getFirstName().length() < 10 && Toni.getFirstName() != null);
        assertTrue(Toni.getLastName().length() < 10 && Toni.getLastName() != null);
        assertTrue(Toni.getPhone().length() == 10 && Toni.getPhone() != null);
        assertTrue(Toni.getAddress().length() < 30 && Toni.getAddress() != null);
       
    }
    
    @Test
    public void testIllegalArgumentsForContactClass(){
        //Test to make sure exception is thrown if ID is null or has too many chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Antonio", "Bethune", "5165578252", "219 Gertrude");
            new Contact("1234566757891", "Antonio", "Bethune", "5125578252", "219 Gertrude");
        });
        
        //Test to make sure exception is thrown if first name or last name is null or has too many chars 
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "Antoniobsewtb", "Bethune", "5165278252", "219 Gertrude");
            new Contact("0", "Antonio", "Bethunebfewbws", "5165578222", "219 Gertrude");
            new Contact("0", null, "Bethune", "5165578252", "219 Gertrude");
            new Contact("0", "Antonio", null, "5165578252", "219 Gertrude");
        });
        
        //Test to make sure exception is thrown if phone number has too many chars or is null
         Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "Antonio", "Bethune", "516557822452", "219 Gertrude");
            new Contact("0", "Antonio", "Bethune", null, "219 Gertrude");
        });       
         
        //Test to make sure exception is thrown if address is to long or is null 
         Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "Antonio", "Bethune", "5165578252", "219 grqewqgrGertqwgrwegrweggrqgfrdaqwrfvqawvcqwavrude");
            new Contact("0", "Antonio", "Bethune", "5165578252", null);
        });                          
    }

}
