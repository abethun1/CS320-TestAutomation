import java.util.*;
import java.time.LocalDate;

/**
 *
 * @author Toni
 */
public class Appointment {
    
    final String ID;
    private LocalDate date;
    private String description;
    
    //Sets up a new Appointment Object with the variables ID Date and Description
    public Appointment(String id, LocalDate n, String d){
        
        if(id == null || id.length() > 10){
            throw new IllegalArgumentException("Invalid ID");
        }
        
        if(n == null || n.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Date cannot be in the past");
        }
        
        if(d == null || d.length() > 50){
            throw new IllegalArgumentException("Invalid description");
        }
        
        this.ID = id;
        this.date = n;
        this.description = d; 
    }
    
    //Get and Set methods for Appointment Object
    public String getID(){
        return this.ID;
    }
    
    public LocalDate getDate(){
        return this.date;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDate(LocalDate n){
        this.date = n;
    }
    
    public void setDescription(String d){
        this.description = d;
    }
    
}
