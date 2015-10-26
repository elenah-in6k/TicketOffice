package core.inputOtpute;


import core.entity.Flight;
import core.entity.Ticket;

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
        printStream.println("Seating position: " + ticket.getNumberOfPlace()+"\n");
    }

    public void printFlightInfo(Flight flight) {
        printStream.println("ticketoffice.oldclasses.FlightImpl: ");
        printStream.println("DateTime: "+ flight.getDateTime());
        printStream.println("City: "+ flight.getIdCity());

    }
}
