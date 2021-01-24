
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class manager extends employee implements Validation {
    private reader obj1 = new reader();
    Trip selectedTrip=new Trip();
    driver selectedDriver=new driver();
    writer obj2=new writer();

   public void setReader(reader reader){
       this.obj1=reader;

   }



    public boolean assignTrip(String driverName,String tripNum) {
    	int j,i,flag=0,flag1=0;
    
    	for( i=0;i<obj1.trips.size();i++) {
    		if(tripNum.equalsIgnoreCase(obj1.trips.get(i).getTripNum())) {
    			selectedTrip=obj1.trips.get(i);
    			flag1=1;
    			break;
    		}
    	}
    	for( j=0;j<obj1.drivers.size();j++) {
    		if(driverName.equalsIgnoreCase(obj1.drivers.get(j).getName())) {
    			selectedDriver=obj1.drivers.get(j);
    			flag=1;
    			break;
    		}
    	}
    	if(flag==1&&flag1==1) {
    	obj1.drivers.get(j).assignedTrips.add(obj1.trips.get(i).getTripNum());
    	obj2.writeDriver(obj1.drivers);
    	return true;
    	}
    	else
    		return false;
    }

    public void AddTrips (String numOfTrip, String source,String destination,String typeofVehichles, String price,String numOfStops,String typeOfTrip,String numOfSeats,String date,String time)throws IOException {
        obj1.readTrips();

    	Trip addedtrip= new Trip();
        addedtrip.setTripNum(numOfTrip);
        
        addedtrip.setSource(source);
        addedtrip.setDestination(destination);
        addedtrip.setTypeOfvehichles(typeofVehichles);
        addedtrip.setTicketPrice(price);
        addedtrip.setNumOfStops(numOfStops);
        addedtrip.setNumOfSeats(numOfSeats);
        addedtrip.setAvailableSeats(numOfSeats);
        addedtrip.setTypeOfTrip(typeOfTrip);
        addedtrip.setDate(date);
        addedtrip.setTime(time);
       obj1.trips.add(addedtrip);
       obj2.writeTrips(obj1.trips);


    }
    public boolean removeTrip(String tripNum){
int flag=0;
int i;
try {
	obj1.readTrips();
	obj1.readDrivers();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


    	for( i=0;i<obj1.trips.size();i++) {
    		if(tripNum.equalsIgnoreCase(obj1.trips.get(i).getTripNum())) {
    			

    			flag=1;
    			obj1.trips.remove(i);
    			break;
    		}
    	}
    
    	
    	if(flag==1) {

    	for(int j=0;j<obj1.drivers.size();j++) {
    		for(int k=0;k<obj1.drivers.get(j).assignedTrips.size();k++) {
    			if(tripNum.equalsIgnoreCase(obj1.drivers.get(j).assignedTrips.get(k))){
    				obj1.drivers.get(j).assignedTrips.remove(k);
    				break;
    			}
    					
    		}
 
    	}
        obj2.writeTrips(obj1.trips);
        obj2.writeDriver(obj1.drivers);

        return true;
    	}
    	else 
    		return false;

    	
    }

	@Override
	public manager validation(String name, String password) {
		// TODO Auto-generated method stub
		manager currentManager=new manager();
		try {
			currentManager = obj1.readManagers();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(obj1.readManagers().getName().equalsIgnoreCase(name)&&obj1.readManagers().getPassword().equalsIgnoreCase(password)) {
				return currentManager;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		       
		return null;
	}

}
