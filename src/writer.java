import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class writer {
    private reader obj1 = new reader();

    public void setReader(reader reader){
        this.obj1=reader;
    }

    public void writeTrips(ArrayList<Trip> trips){
        try{
            FileWriter fw= new FileWriter("trip.txt");
            PrintWriter pw=new PrintWriter(fw);

            for(int i=0;i<trips.size();i++){
                pw.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",trips.get(i).getTripNum(),trips.get(i).getSource(),trips.get(i).getDestination(),trips.get(i).getTypeOfvehichles(),trips.get(i).getTicketPrice(),trips.get(i).getNumOfStops(),trips.get(i).getTypeOfTrip(),trips.get(i).getNumOfSeats(),trips.get(i).getAvailableSeats(),trips.get(i).getDate(),trips.get(i).getTime());
                pw.println();

            }
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writecustomer (ArrayList <customer> customers){
    
        try {
            FileWriter fw= new FileWriter("customer.txt");
            PrintWriter pw=new PrintWriter(fw);
            for(int i =0 ; i<customers.size();i++){
                pw.printf("%s,%s",customers.get(i).getName(),customers.get(i).getPassword());
                for(int j = 0; j<customers.get(i).reservedTrips.size();j++)
                    pw.printf(",%s",customers.get(i).reservedTrips.get(j));
                pw.println();
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void writeDriver (ArrayList<driver> drivers){
        try {
            FileWriter fw= new FileWriter("driver.txt");
            PrintWriter pw=new PrintWriter(fw);
            for (int i =0 ;i < drivers.size();i++){
                pw.printf("%s,%s,%s,%s",drivers.get(i).getName(),drivers.get(i).getPassword(),drivers.get(i).getSalary(),drivers.get(i).getAge());
                for (int j = 0 ; j< drivers.get(i).assignedTrips.size();j++)
                    pw.printf(",%s",drivers.get(i).assignedTrips.get(j));
                pw.println();
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

