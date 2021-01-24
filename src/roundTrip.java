public class roundTrip extends Ticket {
    private Trip selected;
    private Trip selected2;
    private String numOfSeats;

    public roundTrip(Trip selected, Trip selected2, String numOfSeats) {
        this.selected=selected;
        this.selected2=selected2;
        this.numOfSeats=numOfSeats;
    }
    @Override
    public String calculateTicketPrice() {
        int x=Integer.parseInt(selected.getTicketPrice())+Integer.parseInt(selected2.getTicketPrice());
        int y=Integer.parseInt(numOfSeats);
        double z=x*y;
         z=z*0.8;
        String price=Double.toString(z);
        return price;
    }
}
