/**
 * Created by employee on 10/20/15.
 */
public class TicketOffice {


    public static void main(String[] s) {
        AllFlights flights = new AllFlightsImpl();
        flights.createFlightsList();
        Printer printerImpl = new PrinterImpl(System.out);
        printerImpl.printHelloMessage();
        InputOptions inputOptionsImpl = new InputOptionsImpl(System.in, printerImpl);
        FlightOptions flightOptions = inputOptionsImpl.setOptions();
        FlightImpl flightImpl = flights.searchFlight(flightOptions);
        if (flightImpl != null) {
            for (int i = 0; i < flightOptions.numberOfTicket; i++) {
                printerImpl.printFlightInfo(flightImpl);
                printerImpl.printTicket(flightImpl.buyTicket());
            }
        } else {
            printerImpl.printSorryMessage();
        }
    }
}
