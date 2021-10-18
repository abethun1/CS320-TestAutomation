import java.util.ArrayList;

/**
 *
 * @author Toni
 */
public class AppointmentService {
        
    private ArrayList<Appointment> appointmentServices = new ArrayList<Appointment>();
    
    //Sets up an empty ArrayList to take Appointment objects
    public AppointmentService(){
        ArrayList<Appointment> tS;
        tS = this.appointmentServices;
    }
    
    public int getSize(){
        return this.appointmentServices.size();
    }
    
   //Returns an Appointment object by ID from the Appointment Service ArrayList otherwise throws an exception if Appointment doesn't exist 
   public Appointment getAppointmentByID(String id){
        for(int i = 0; i < this.appointmentServices.size(); i++){
            if(id == this.appointmentServices.get(i).getID()){
                return this.appointmentServices.get(i);
            }
        }
        throw new IllegalArgumentException("Appointment with this ID doesn't exist");
    }
   
   //Adds an Appointment Object to the Appointment Service ArrayList
   public void addAppointment(Appointment t){
        for(int i = 0; i < this.appointmentServices.size(); i++){
            if(t.getID() == this.appointmentServices.get(i).getID())
                throw new IllegalArgumentException("Appointment with this ID already exist");
        }
        this.appointmentServices.add(t);
    }
    
   //Deletes an Appointment based on ID from Appointment Service ArrayList or throws an exception if that Appointment doesnt exist
    public void deleteAppointment(String id){
        for(int i = 0; i < this.appointmentServices.size(); i++){
            if(id == this.appointmentServices.get(i).getID()){
                this.appointmentServices.remove(i);
                break;
            }
            else if(i == this.appointmentServices.size() - 1)
                throw new IllegalArgumentException("Appointment with this ID does not exist");
        }
    }
}
