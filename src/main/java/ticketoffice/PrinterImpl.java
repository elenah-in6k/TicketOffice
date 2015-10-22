package ticketoffice;

import java.io.PrintStream;

/**
 * Created by employee on 10/21/15.
 */
public class PrinterImpl implements Printer  {
    PrintStream printStream;

    public PrinterImpl(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printHelloMessage() {
        printStream.println("Hello!\nPlease input which ticket you want.");
    }

    public void printInputDateMessage(){
        printStream.print("Input date in format dd.mm.yyyy: ");
    }

    public void printInputTicketMessage() {
        printStream.print("Input quntity ticket: ");
    }

    public void printInputCityMessage(){
        printStream.print("Input city: ");
    }

    public void printSorryMessage() {
        printStream.println("Sorry, our office don't have  ticket");
    }

    public void printTicket(Ticket ticket) {
        printStream.println("Seating position: " + ticket.seatingPosition+"\n");
    }

    public void printFlightInfo(FlightImpl flightImpl) {
        printStream.println("ticketoffice.FlightImpl: ");
        printStream.println("Date: "+ flightImpl.date);
        printStream.println("Time: "+ flightImpl.time);
        printStream.println("ticketoffice.City: "+ flightImpl.city.name);

    }
}
