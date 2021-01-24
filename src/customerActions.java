
//import sun.security.krb5.internal.Ticket;

import java.util.ArrayList;
import java.util.Map;

public interface customerActions {
    /*
     * Customer can search for trips and list them based on some criteria
     *
     *@param filter
     * used to handle trip search
     * if null, then return all trips
     *@return list of trips that matches the search criteria
     */
 public ArrayList<Trip> listTrips(String keySource,String keyDestination);
    /**
     *@param selected
     * the selected trip by the customer
     *@param selected2
     * this parameter will be null if one-way trip
     *@paramnumOfSeats
     * if null, check for a single available seat
     *@return true if there is available seats
     */
    public boolean checkAvailability(Trip selected,Trip selected2 , String numOfSeats);
    /**
     *@param selected
     * the selected trip by Customer
     *@param selected2
     * this parameter will be null if one-way trip
     *@param customer
     * the customer currently using the system
     *@paramnumOfSeats
     * it can't be null, and it must be > 0
     *@return the ticket with the total amount of money paid
     */
  public String reserve(Trip selected,Trip selected2);
}