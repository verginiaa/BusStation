import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Trip {

    private String tripNum;
    private String source;
    private String destination;
    private String typeOfvehichles;
    private String ticketPrice;
    private String numOfStops;
    private String typeOfTrip;
    private String numOfSeats;
    private String availableSeats;
    private String kindOfTicket;
    private String date;
    private String time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getKindOfTicket() {
        return kindOfTicket;
    }

    public void setKindOfTicket(String kindOfTicket) {
        this.kindOfTicket = kindOfTicket;
    }



    public String getTripNum() {
        return tripNum;
    }

    public void setTripNum(String tripNum) {
        this.tripNum = tripNum;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTypeOfvehichles() {
        return typeOfvehichles;
    }

    public void setTypeOfvehichles(String typeOfvehichles) {
        this.typeOfvehichles = typeOfvehichles;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getNumOfStops() {
        return numOfStops;
    }

    public void setNumOfStops(String numOfStops) {
        this.numOfStops = numOfStops;
    }

    public String getTypeOfTrip() {
        return typeOfTrip;
    }

    public void setTypeOfTrip(String typeOfTrip) {
        this.typeOfTrip = typeOfTrip;
    }

    public String getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(String numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(String availableSeats) {
        this.availableSeats = availableSeats;
    }



}
