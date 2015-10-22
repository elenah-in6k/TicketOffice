package ticketoffice;

/**
 * Created by employee on 10/22/15.
 */
public class TicketOfficeController {

    private final InputOptions input;
    private TicketOffice ticketOffice;
    private final Printer printer;

    public TicketOfficeController(InputOptions input, TicketOffice ticketOffice, Printer printer) {
        this.input = input;
        this.ticketOffice = ticketOffice;
        this.printer = printer;
    }

    public void openTicketOffice() {
        FlightOptions flightOptions = input.readSearchOptions();
        FlightImpl flight = ticketOffice.searchFlight(flightOptions);
        hasSearchFlight(flight);
        //printer.printTicket(flight.buyTicket());
    }

    public void hasSearchFlight(FlightImpl flight) {
        if (flight != null) {
            printer.printFlightInfo(flight);
        } else {
            printer.printSorryMessage();
        }
    }
}
