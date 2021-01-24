
//package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class reader {
    public reader() {

    }

    public ArrayList<customer> customers = new ArrayList<customer>();
    String[] str = new String[20];

    public void readCustomers() {

        try {
            FileReader fr = new FileReader("customer.txt");

            BufferedReader br = new BufferedReader(fr);
            String str2;
            int i = 0;
            while ((str2 = br.readLine()) != null) {
                str[i] = str2;

                String[] temp = str[i].split(",", 20);
                customer customer = new customer();
                customer.setName(temp[0]);
                customer.setPassword(temp[1]);
                int j = 2;
                int k = 0;
                while (j < (temp.length)) {
                    customer.reservedTrips.add(k, temp[j]);

                    k++;
                    j++;
                }
                customers.add(customer);
                i++;
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Trip> trips = new ArrayList<Trip>();

    public void readTrips() throws IOException {

        String[] str1 = new String[80];

        try {
            FileReader fr = new FileReader("trip.txt");
            BufferedReader br = new BufferedReader(fr);
            String str2;
            int i = 0;

            while ((str2 = br.readLine()) != null) {
                str1[i] = str2;

                String[] temp = str1[i].split(",", 11);
                Trip trip = new Trip();
                trip.setTripNum(temp[0]);
                trip.setSource(temp[1]);
                trip.setDestination(temp[2]);
                trip.setTypeOfvehichles(temp[3]);
                trip.setTicketPrice(temp[4]);
                trip.setNumOfStops(temp[5]);
                trip.setTypeOfTrip(temp[6]);
                trip.setNumOfSeats(temp[7]);
                trip.setAvailableSeats(temp[8]);
                trip.setDate(temp[9]);
                trip.setTime(temp[10]);
                trips.add(trip);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    ArrayList<driver> drivers = new ArrayList<driver>();

    public void readDrivers() throws IOException {
        String[] str1 = new String[20];//3add el nas el fel file


int i=0;
        try {
            FileReader fr = new FileReader("driver.txt");
            BufferedReader br = new BufferedReader(fr);
            String str2;
            while ((str2 = br.readLine()) != null) {
                str1[i] = str2;

                String[] temp = str1[i].split(",", 10);
                driver driver = new driver();
                driver.setName(temp[0]);
                driver.setPassword(temp[1]);
                driver.setSalary(temp[2]);
                driver.setAge(temp[3]);
                int j = 4;
                int k = 0;
                while (j < (temp.length)) {
                    driver.assignedTrips.add(k, temp[j]);

                    k++;
                    j++;
                }
                drivers.add(driver);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
 

    public manager readManagers() throws IOException {
         String []str1=new String[1];
        manager managers = new manager();

        try {
            FileReader fr = new FileReader("manager.txt");
            BufferedReader br = new BufferedReader(fr);
            String str2;

            while ((str2 = br.readLine()) != null) {
                String[] temp = str2.split(",", 10);
                managers.setName(temp[0]);
                managers.setPassword(temp[1]);
                managers.setSalary(temp[2]);
                managers.setAge(temp[3]);
            }
        }   catch (FileNotFoundException e) {
        e.printStackTrace();
    }
      return managers;
}
}