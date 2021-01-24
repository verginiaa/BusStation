//import jdk.internal.cmm.SystemResourcePressureImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class customer implements customerActions ,Validation {
    private String name;
    private String password;
    //3dd el fel files


    private reader trip;

    private String numOfSeats;
    private  Trip tripselected;
    private Trip tripselected2;
    private reader obj1=new reader();
    private writer obj2=new writer ();

    public void setReader(reader reader){
        this.obj1=reader;
    }


    public Trip getTripSelected2() {
        return tripselected2;
    }

    public void setTripSelected2(Trip tripselected2) {
        this.tripselected2 = tripselected2;
    }


    public ArrayList < String> reservedTrips=new ArrayList<>();//3add el trips

   

    public customer(){

    }
    public String getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(String numOfSeats) {
        this.numOfSeats = numOfSeats;
    }
    public customer(reader obj) {
        this.trip = obj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Trip> listTrips() {
        return obj1.trips;
    }

    public ArrayList<Trip> listTrips(String keySource, boolean missing) {
        ArrayList<Trip> foundTrips = new ArrayList<Trip>();
        if(missing){
            for (int i = 0; i <= 1; i++)
            {
                String str = obj1.trips.get(i).getSource();
                if (keySource.equals(str)) {
                    foundTrips.add(obj1.trips.get(i));
                   
                }

            }
        }
        else{
            for (int i = 0; i <= 1; i++)
            {
                String str2 = obj1.trips.get(i).getDestination();
                if (keySource.equals(str2)) {
                    foundTrips.add(obj1.trips.get(i));
                    
                }

            }
        }
        return foundTrips;

    }

        public ArrayList<Trip> listTrips(String keySource, String keyDestination) {
        ArrayList<Trip> foundTrips = new ArrayList<Trip>();

        for (int i = 0; i <obj1.trips.size(); i++)
        {
        
           String str = obj1.trips.get(i).getSource();
            String str2 = obj1.trips.get(i).getDestination();

            if (keySource.equals(str) && keyDestination.equals(str2)) {
                foundTrips.add(obj1.trips.get(i));
            }

        }
        return foundTrips;
    }

    public ArrayList<Trip> listTrips(String keySource, String keyDestination,boolean round) {
        ArrayList<Trip> foundTrips = new ArrayList<Trip>();
        for (int i = 0; i <obj1.trips.size(); i++)
        {
            String str = obj1.trips.get(i).getSource();
            String str2 = obj1.trips.get(i).getDestination();

            if (keySource.equals(str2) && keyDestination.equals(str)) {
                foundTrips.add(obj1.trips.get(i));
            }

        }
        return foundTrips;

    }
    public boolean checkAvailability(Trip selected,Trip selected2 , String numOfSeats) {
        if (numOfSeats==null)
                 this.numOfSeats = "1";
        else
            this.numOfSeats=numOfSeats;

        if(selected2==null){
        if (Integer.parseInt(this.numOfSeats) > Integer.parseInt(selected.getAvailableSeats())) {
            return false;

        }
        else{
          
            return true;

        }
        }
        else {

            if ((Integer.parseInt(this.numOfSeats)>Integer.parseInt(selected.getAvailableSeats())) || (Integer.parseInt(this.numOfSeats)>Integer.parseInt(selected2.getAvailableSeats()) ))
            {
                return  false;

            }
            else
                return true;
        }
    }


    public String reserve(Trip selected,Trip selected2)

    {
            if(selected2==null){
            oneWay ticket=new oneWay(selected,numOfSeats);
            String price=ticket.calculateTicketPrice();
            tripselected=selected;


            return price;
        }
        else
        {
            roundTrip ticket=new roundTrip(selected,selected2,numOfSeats);
            String price=ticket.calculateTicketPrice();
            tripselected=selected;
            tripselected2=selected2;
         

            return  price;
        }
    }
    public ArrayList<Trip> setArrayList() {
    	ArrayList<Trip> obj=new ArrayList<>();
    	obj1.readCustomers();
    	for(int i=0;i<obj1.trips.size();i++) {
    		obj.add(i, obj1.trips.get(i));
    	}
    	return obj;
    	
    }
    public void updateArrays(customer currentcustomer) {
        
             String str =tripselected.getTripNum();
            str=str.concat(" ");
            str=str.concat(numOfSeats);
            currentcustomer.reservedTrips.add(str);
            int x = Integer.parseInt(tripselected.getAvailableSeats()) - Integer.parseInt(numOfSeats);
            String y = Integer.toString(x);
            tripselected.setAvailableSeats(y);
            if(tripselected2!=null){
                String str2 =tripselected2.getTripNum();
                str2=str2.concat(" ");
                str2=str2.concat(numOfSeats);
                currentcustomer.reservedTrips.add(str2);
                int z = Integer.parseInt(this.tripselected2.getAvailableSeats()) - Integer.parseInt(numOfSeats);
                String m = Integer.toString(z);
                this.tripselected2.setAvailableSeats(m);

                for (int i=0; i<obj1.customers.size();i++) {
                	if (currentcustomer.getPassword().equalsIgnoreCase(obj1.customers.get(i).getPassword()))
                	{
                		obj1.customers.get(i).reservedTrips.add(str2);
                	}
                	
                		
                }
                for (int i=0; i<obj1.trips.size();i++) {
                	if(tripselected2.getTripNum().equalsIgnoreCase(obj1.trips.get(i).getTripNum())) {
                		obj1.trips.get(i).setAvailableSeats(m);
                	}

                }
                
            }
     

            for (int i=0; i<obj1.customers.size();i++) {
            	if (currentcustomer.getPassword().equalsIgnoreCase(obj1.customers.get(i).getPassword()))
            	{
            		obj1.customers.get(i).reservedTrips.add(str);
            	}
            		
            		
            }
        	

            for (int i=0; i<obj1.trips.size();i++) {
            	if(tripselected.getTripNum().equalsIgnoreCase(obj1.trips.get(i).getTripNum())) {
            		obj1.trips.get(i).setAvailableSeats(y);
            	}

            }
            
            obj2.writeTrips(obj1.trips);
            obj2.writecustomer(obj1.customers);
        
    }
    public void cancel(customer currentCustomer, Trip cancelledTrip){

        int i=0;
       
        while(currentCustomer.reservedTrips.size()>0){
               String[] result= currentCustomer.reservedTrips.get(i).split(" ",10);
            if( result[0].equals(cancelledTrip.getTripNum())) {
               int z=Integer.parseInt(cancelledTrip.getAvailableSeats()) ;
               int y =Integer.parseInt(result[1]);
               int m=z+y;
               obj1.trips.get(i).setAvailableSeats(Integer.toString(m));
               System.out.print(obj1.trips.get(i).getAvailableSeats());

                break;
            }
                i++;
        }
        for (int j=0; j<obj1.customers.size();j++) {
        	if (currentCustomer.getPassword().equalsIgnoreCase(obj1.customers.get(j).getPassword()))
        	{   

        		obj1.customers.get(j).reservedTrips.remove(i);
        	}
        		

        }
        
        obj2.writeTrips(obj1.trips);
        obj2.writecustomer(obj1.customers);


    }
    public customer validation(String name, String password) {
    	obj1.readCustomers();
    	for(int i = 0; i<obj1.customers.size();i++) {
    		if(obj1.customers.get(i).getName().equalsIgnoreCase(name) && obj1.customers.get(i).getPassword().equalsIgnoreCase(password)) {
    			return obj1.customers.get(i);
    		}
    	}
    	return null;
    }

}
