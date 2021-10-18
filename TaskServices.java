import java.util.ArrayList;

/**
 *
 * @author Toni
 */
public class TaskServices {
    
    private ArrayList<Task> taskServices = new ArrayList<Task>();
    
    public TaskServices(){
        ArrayList<Task> tS;
        tS = this.taskServices;
    }
    
    public int getSize(){
        return this.taskServices.size();
    }
    
    //This returns a Task from the Task Service arraylist based on the string ID given
    //If there are no Task with the ID then an exception is thrown
   public Task getTaskByID(String id){
        for(int i = 0; i < this.taskServices.size(); i++){
            if(id == this.taskServices.get(i).getID()){
                return this.taskServices.get(i);
            }
        }
        throw new IllegalArgumentException("Task with this ID doesn't exist");
    }
    
   //This adds a Task object tot the current Task Service arraylist
   //If a Task with a similar ID exist an exception is thrown
   public void addTask(Task t){
        for(int i = 0; i < this.taskServices.size(); i++){
            if(t.getID() == this.taskServices.get(i).getID())
                throw new IllegalArgumentException("Task with this ID already exist");
        }
        this.taskServices.add(t);
    }
    
   //This deletes a task from the the current Task services by the ID given
   //If no task with that ID is present an exception is thrown
    public void deleteTask(String id){
        for(int i = 0; i < this.taskServices.size(); i++){
            if(id == this.taskServices.get(i).getID()){
                this.taskServices.remove(i);
                break;
            }
            else if(i == this.taskServices.size() - 1)
                throw new IllegalArgumentException("Task with this ID does not exist");
        }
    }
    
    //These are the methods to update different parts of the TAsk that are already in the Task Service arraylist
    public void updateTaskName(String id, String n){
        if(n == null || n.length() > 20){
            throw new IllegalArgumentException("Invalid task name");
        }
        this.getTaskByID(id).setName(n);
    }
    
    public void updateTaskDescription(String id, String n){
        if(n == null || n.length() > 50){
            throw new IllegalArgumentException("Invalid description");
        }    
       this.getTaskByID(id).setDescription(n);
    }
}
