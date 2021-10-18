/**
 *
 * @author Toni
 */
public class Contact {
    
    final String ID; 
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    
    
    //Constructor method that makes a Contact object based on the parameters set up as global private variables
    //If there is an invalid entry for one of the options or an option is left null, then an exception is thrown
    public Contact(String id, String fN, String lN, String p, String a){
        
        if(id == null || id.length() > 10){
            throw new IllegalArgumentException("Invalid ID");
        }
        
        if(fN == null || fN.length() > 10){
            throw new IllegalArgumentException("Invalid first name");
        }
        
        if(lN == null || lN.length() > 10){
            throw new IllegalArgumentException("Invalid last name");
        }
        
        if(p == null || p.length() != 10){
            throw new IllegalArgumentException("Invalid phone number");
        }
        
        if(a == null || a.length() > 30){
            throw new IllegalArgumentException("Invalid address");
        }
        
        this.ID = id;
        this.firstName = fN;
        this.lastName = lN;
        this.phone = p;
        this.address = a;
    }
    
    
    //These are the Get and Set methods for the Contact object variables
    //Note: There is no set for ID because it is unique and can't be changed
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getID(){
        return this.ID;
    }
    
    public String getAddress(){
        return this.address;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setFirstName(String fN){
        this.firstName = fN;
    }
    
    public void setLastName(String lN){
        this.lastName = lN;
    }
    
    public void setAddress(String a){
        this.address = a;
    }

    public void setPhone(String p){
        this.phone = p;
    }    
}
