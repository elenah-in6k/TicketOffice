/**
 * Created by employee on 10/21/15.
 */
public class Printer {

    public void printSorryMessage() {
        System.out.println("Sorry, our office don't have  ticket");
    }

    public void printTicket(Ticket ticket) {
        System.out.println("Seating position: " + ticket.seatingPosition);
    }

    public void printFlightInfo(Flight flight) {
        System.out.println("Flight: ");
        System.out.println("Date: "+flight.date);
        System.out.println("Time: "+flight.time);
        System.out.println("City: "+flight.city.name);

    }
}
