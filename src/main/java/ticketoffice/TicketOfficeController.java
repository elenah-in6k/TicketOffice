package ticketoffice;

import core.entity.Flight;
import core.inputOtpute.FlightOptions;
import core.inputOtpute.InputOptions;
import core.inputOtpute.Printer;


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
       // Flight flight = ticketOffice.searchFlight(flightOptions);
       // hasSearchFlight(flight);
        //printer.printTicket(flight.buyTicket());
    }

    public void hasSearchFlight(Flight flight) {
        if (flight != null) {
            printer.printFlightInfo(flight);
        } else {
            printer.printSorryMessage();
        }
    }
}
