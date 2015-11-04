import core.entity.City;
import core.entity.Flight;
import core.inputOutput.InputOptions;
import core.inputOutput.Printer;
import service.ServiceBaseImpl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by employee on 10/22/15.
 */
public class TicketOfficeController {

    private final InputOptions input;

    private final Printer printer;
    private final ServiceBaseImpl service;

    public TicketOfficeController(InputOptions input, Printer printer, ServiceBaseImpl service) {
        this.input = input;
        this.printer = printer;
        this.service = service;
        //service.TicketOffice t = new service.TicketOffice()
    }
    private Date getDate(String date1) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateU = sdf1.parse(date1);
        return new Date(dateU.getTime());
    }
    public void openTicketOffice() throws ParseException  {

        //service.createFlight(1, getDate("2015-12-3"), "Varshava121", 40);

        List<Flight> flightss = service.getAllFlights();
        for (Flight f : flightss) {
            printer.printFlightInfo(f);
        }
        List<City> allCity = service.getAllCity();

        for (City o : allCity) {
            System.out.println(o.getId() + " " + o.getName());
        }
//        FlightOptions flightOptions = input.readSearchOptions();
//        List<Flight> flights = service.findFlights(flightOptions);
//
//        hasSearchFlight(flights);

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
