public class oneWay extends Ticket {
    private Trip selected;
    private String numOfSeats;

    public oneWay(Trip selected, String numOfSeats) {
        this.selected=selected;
        this.numOfSeats=numOfSeats;
    }

    @Override
    public String calculateTicketPrice() {
        int x=Integer.parseInt(selected.getTicketPrice());
        int y=Integer.parseInt(numOfSeats);
        int z=x*y;
        String price=Integer.toString(z);
        return price;

    }
}

