 /*
 * @author Toni
 */
public class Task {
    
    final String ID;
    private String name;
    private String description;
    
    public Task(String id, String n, String d){
        
        if(id == null || id.length() > 10){
            throw new IllegalArgumentException("Invalid ID");
        }
        
        if(n == null || n.length() > 20){
            throw new IllegalArgumentException("Invalid name");
        }
        
        if(d == null || d.length() > 50){
            throw new IllegalArgumentException("Invalid description");
        }
        
        this.ID = id;
        this.name = n;
        this.description = d; 
    }
    
    //These are the get and set methods for the variables of the Task class
    public String getID(){
        return this.ID;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public void setDescription(String d){
        this.description = d;
    }
    
    
}
