import java.util.ArrayList;

/**
 *
 * @author Toni
 */
public class ContactService {
    
    private ArrayList<Contact> contactServices = new ArrayList<Contact>();
    
    //Constructor method to make an arraylist object for the Contact Services class
    public ContactService(){
        ArrayList<Contact> contactServices = this.contactServices;
    }
    
    //Returns the size of the current Contact Services object
    public int getSize(){
        return this.contactServices.size();
    }
    
    //Returns a contact based on the unique ID String given by the user.
    //If there is no match then an exception is thrown
    public Contact getContactByID(String id){
        for(int i = 0; i < this.contactServices.size(); i++){
            if(id == this.contactServices.get(i).getID()){
                return this.contactServices.get(i);
            }
        }
        throw new IllegalArgumentException("Customer with this ID doesn't exist");
    }
    
    //Adds a Contact object given by the user to the Contact Service object.
    //If the Contact has an ID that is already in the Contact service list, then an exception is thrown
    public void addContact(Contact c){
        for(int i = 0; i < this.contactServices.size(); i++){
            if(c.getID() == this.contactServices.get(i).getID())
                throw new IllegalArgumentException("Customer with this ID already exist");
        }
        this.contactServices.add(c);
    }
    
    //Deletes a Contact object from the Contact Service list by unique ID given by user
    //If the ID is not found to be associated with one of the Contact objects and exception is thrown
    public void deleteContact(String id){
        for(int i = 0; i < this.contactServices.size(); i++){
            if(id == this.contactServices.get(i).getID()){
                this.contactServices.remove(i);
                break;
            }
            else if(i == this.contactServices.size() - 1)
                throw new IllegalArgumentException("Customer with this ID does not exist");
        }
    }
    
    //Update methods to edit the fields of a Contact object within the COntact Service list by unique ID
    //The methods take the unique ID as the first String variable and then the actual updated String
    //If the updating string fails the requirements of the contact class than an exception is thrown.
    
    public void updateFirstName(String id, String n){
        if(n == null || n.length() > 10){
            throw new IllegalArgumentException("Invalid first name");
        }
        this.getContactByID(id).setFirstName(n);
    }
    
    public void updateLastName(String id, String n){
        if(n == null || n.length() > 10){
            throw new IllegalArgumentException("Invalid last name");
        }    
       this.getContactByID(id).setLastName(n);
    }
    
    public void updatePhone(String id, String n){
        if(n == null || n.length() != 10){
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.getContactByID(id).setPhone(n);
    }
    
    public void updateAddress(String id, String n){
        if(n == null || n.length() > 30){
            throw new IllegalArgumentException("Invalid address");
        }
        this.getContactByID(id).setAddress(n);
    }
    
    public void printContactList(){
        for(int i = 0; i < this.contactServices.size(); i++){
            System.out.println("ID: " + this.contactServices.get(i).getID() + 
                    " First Name: " + this.contactServices.get(i).getFirstName() +
                    " Last Name: " + this.contactServices.get(i).getLastName() +
                    " Address: " + this.contactServices.get(i).getAddress() + 
                    " Phone: " + this.contactServices.get(i).getPhone());
        }
    }
}