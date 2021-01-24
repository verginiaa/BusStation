import java.util.ArrayList;

public class driver extends employee implements Validation {
    ArrayList<String> assignedTrips= new ArrayList<>();
    private reader obj1=new reader();
public void setReader(reader obj1) {
	this.obj1=obj1;
}

	@Override
	public driver validation(String name, String password) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<obj1.drivers.size();i++) {
    		if(obj1.drivers.get(i).getName().equalsIgnoreCase(name) && obj1.drivers.get(i).getPassword().equalsIgnoreCase(password)) {
    			return obj1.drivers.get(i);
    		}
    	}
		return null;
	}
    


}
