/**
 * Created by employee on 10/21/15.
 */
public class Printer {

    public void printHelloMessage() {
        System.out.println("Hello!\nPlease input which ticket you want.");
    }
    public void printInputDateMessage(){
    System.out.print("Input date in format dd.mm.yyyy: ");
    }
    public void printInputTicketMessage() {
        System.out.print("Input quntity ticket: ");
    }
    public void printInputCityMessage(){
        System.out.print("Input city: ");
    }
    public void printSorryMessage() {
        System.out.println("Sorry, our office don't have  ticket");
    }

    public void printTicket(Ticket ticket) {
        System.out.println("Seating position: " + ticket.seatingPosition+"\n");
    }

    public void printFlightInfo(Flight flight) {
        System.out.println("Flight: ");
        System.out.println("Date: "+flight.date);
        System.out.println("Time: "+flight.time);
        System.out.println("City: "+flight.city.name);

    }
}
