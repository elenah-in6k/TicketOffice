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
    List<Flight> flights = new ArrayList<Flight>();

    public static void main(String[] s) {
        TicketOffice ticketOffice = new TicketOffice();
        ticketOffice.createFlightsList();
        InputOptions inputOptions = new InputOptions(System.in);
        Printer printer = new Printer();
        FlightOptions flightOptions = inputOptions.setOptions();
        Flight flight = ticketOffice.searchFlight(flightOptions);
        if (flight != null) {
            for (int i = 0; i < flightOptions.numberOfTicket; i++) {
                printer.printFlightInfo(flight);
                printer.printTicket(flight.buyTicket());
            }
        } else {
            printer.printSorryMessage();

        }

    }

    public void createFlightsList() {
        flights.add(new Flight(new City("Kyiv"), 20,
                LocalDate.parse("27/11/2015",
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse("12:15")));
        flights.add(new Flight(new City("Odesa"), 30,
                LocalDate.parse("15/11/2015",
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse("17:15")));
        flights.add(new Flight(new City("Lviv"), 40,
                LocalDate.parse("27/11/2015",
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse("12:15")));

    }

    public Flight searchFlight(FlightOptions flightOptions) { // LocalDate date, int numberOfEmptyPlace, City city){
//       int indexOfFlight = 2048;
//        for(Flight flight : flights){
//            if((flight.isNearDate(flightOptions.date))&
//                    (flight.getNumberOfEmptyPlaces() >= flightOptions.numberOfTicket)&
//                    (flight.city.name == flightOptions.city.name)) {
//                indexOfFlight =  flights.indexOf(flight);
//                break;
//            }
//        }
//        return indexOfFlight;
        if (flights.size() == 0) return  null;
        Flight flight = flights.get(0);
        if (flightOptions.test(flight))
        return flight;
        return null;
//        return null;
    }


    public void addFlight(Flight flight) {
        flights.add(flight);
    }
}
