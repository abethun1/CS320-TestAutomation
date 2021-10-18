import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	 public void ContactServiceCreationAndAddTest() {
        ContactService agent = new ContactService();
        
        Contact Toni = new Contact("0", "Antonio", "Bethune", "5165578252", "219 Gertrude");
        Contact Chris = new Contact("1", "Chris", "Bethune", "5165578252", "219 Gertrude");
        Contact John = new Contact("2", "John", "Bethune", "5165578252", "219 Gertrude");
        Contact Mary = new Contact("3", "Mary", "Bethune", "5165578252", "219 Gertrude");
        
        //Test the creation of the contact services arraylist and that it is empty
        assertTrue(agent.getSize() == 0);
        
        agent.addContact(Toni);
        
        //Test that the contact services array list has gotten bigger and contains the added contacts
        assertTrue(agent.getSize() == 1);
        
        agent.addContact(Chris);
        agent.addContact(John);
        agent.addContact(Mary);
        
        assertTrue(agent.getSize() == 4);
        
        
	}
	
	@Test
	public void DeletionTest() {
		
		ContactService agent = new ContactService();
        
        Contact Toni = new Contact("0", "Antonio", "Bethune", "5165578252", "219 Gertrude");
        Contact Chris = new Contact("1", "Chris", "Bethune", "5165578252", "219 Gertrude");
        Contact John = new Contact("2", "John", "Bethune", "5165578252", "219 Gertrude");
        Contact Mary = new Contact("3", "Mary", "Bethune", "5165578252", "219 Gertrude");
        
        agent.addContact(Toni);
        agent.addContact(Chris);
        agent.addContact(John);
        agent.addContact(Mary);
        
        agent.deleteContact("1");
        
        //Test that the contact services array list has shrunk and a contact has been deleted
        assertTrue(agent.getSize() == 3);
        
	}
	
	@Test
	public void UpdateTest() {
		ContactService agent = new ContactService();
        
        Contact Toni = new Contact("0", "Antonio", "Bethune", "5165578252", "219 Gertrude");
        
        agent.addContact(Toni);
        
        
        //Test that each update method works for the contact service class
        assertTrue(Toni.getFirstName().equals("Antonio"));
        assertTrue(Toni.getLastName().equals("Bethune"));
        assertTrue(Toni.getPhone().equals("5165578252"));
        assertTrue(Toni.getAddress().equals("219 Gertrude"));
        
        agent.updateFirstName("0", "Toni");
        agent.updateLastName("0", "Masters");
        agent.updatePhone("0", "1234567890");
        agent.updateAddress("0", "210 Gertrude");
       
        assertTrue(Toni.getFirstName().equals("Toni"));
        assertTrue(Toni.getLastName().equals("Masters"));
        assertTrue(Toni.getPhone().equals("1234567890"));
        assertTrue(Toni.getAddress().equals("210 Gertrude"));
	}
	
	@Test
	public void GetContactTest() {
		ContactService agent = new ContactService();
        
        Contact Toni = new Contact("0", "Antonio", "Bethune", "5165578252", "219 Gertrude");
        Contact Chris = new Contact("1", "Chris", "Bethune", "5165578252", "219 Gertrude");
        
        agent.addContact(Toni);
        agent.addContact(Chris);
        
        //Test the the Contact object received matches the Contact ID of the String that was passed
        assertTrue(agent.getContactByID("1").equals(Chris));
        assertTrue(agent.getContactByID("0").equals(Toni));
	}
	
	@Test
	public void GetContactExceptionTest() {
		ContactService agent = new ContactService();
        
        Contact Toni = new Contact("0", "Antonio", "Bethune", "5165578252", "219 Gertrude");
        Contact Chris = new Contact("1", "Chris", "Bethune", "5165578252", "219 Gertrude");
        
        agent.addContact(Toni);
        agent.addContact(Chris);
        
        //Test that an exception is thrown if you are trying to get a Contact from the Contact Service list that isn't there
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            agent.getContactByID("69");
	        });
	}

	@Test
	public void DeleteExceptionTest() {
		ContactService agent = new ContactService();
        
        Contact Toni = new Contact("0", "Antonio", "Bethune", "5165578252", "219 Gertrude");
        Contact Chris = new Contact("1", "Chris", "Bethune", "5165578252", "219 Gertrude");
        
        agent.addContact(Toni);
        agent.addContact(Chris);
        
        //Test that you can't delete a Contact by ID if there is no Contact with that ID
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            agent.addContact(Toni);
	            agent.deleteContact("420");
	        });
	}
}
