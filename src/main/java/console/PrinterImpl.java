package console;


import core.entity.City;
import core.entity.Flight;
import core.entity.Ticket;

import java.io.PrintStream;
import java.util.List;

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
        printStream.print("Input date in format yyyy-mm-dd: ");
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
        printStream.println("Flight: ");
        printStream.println("DateTime: "+ flight.getDateTime());
        printStream.println("City: "+ flight.getCity().getName());
        printStream.println("NumberOfEmptyPlace: "+ flight.getNumberOfEmptyPlaces()+"\n");

    }

}
