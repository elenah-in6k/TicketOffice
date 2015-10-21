import java.rmi.NoSuchObjectException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by employee on 10/20/15.
 */
public class TicketOffice {


    public static void main(String[] s) {
        AllFlights flights = new AllFlights();
        flights.createFlightsList();
        InputOptions inputOptions = new InputOptions(System.in);
        Printer printer = new Printer();
        FlightOptions flightOptions = inputOptions.setOptions();
        Flight flight = flights.searchFlight(flightOptions);
        if (flight != null) {
            for (int i = 0; i < flightOptions.numberOfTicket; i++) {
                printer.printFlightInfo(flight);
                printer.printTicket(flight.buyTicket());
            }
        } else {
            printer.printSorryMessage();

        }

    }




}
