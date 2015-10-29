import core.entity.City;
import core.entity.Flight;
import core.inputOutput.FlightOptions;
import core.inputOutput.InputOptions;
import core.inputOutput.Printer;

import java.text.ParseException;
import java.util.List;


/**
 * Created by employee on 10/22/15.
 */
public class TicketOfficeController {

    private final InputOptions input;

    private final Printer printer;
    private final ServiceTicketOffice service;

    public TicketOfficeController(InputOptions input, Printer printer, ServiceTicketOffice service) {
        this.input = input;
        this.printer = printer;
        this.service = service;
        //TicketOffice t = new TicketOffice()
    }

    public void openTicketOffice() throws ParseException  {


        List<Flight> flightss = service.getAllFlights();
        for (Flight f : flightss) {
            printer.printFlightInfo(f);
        }
        List<City> allCity = service.getAllCity();

        for (City o : allCity) {
            System.out.println(o.getId() + " " + o.getName());
        }
        FlightOptions flightOptions = input.readSearchOptions();
        List<Flight> flights = service.findFlights(flightOptions);

        hasSearchFlight(flights);

    }

    public void hasSearchFlight(List<Flight> flights) {
        if (!flights.isEmpty()) {
            for (Flight o : flights) {
                printer.printFlightInfo(o);
            }
        } else {
            printer.printSorryMessage();
        }
    }
}
