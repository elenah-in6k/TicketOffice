package ticketoffice;

import core.daoInterface.FlightDao;
import core.entity.Flight;
import core.inputOtpute.FlightOptions;
import core.inputOtpute.InputOptions;
import core.inputOtpute.Printer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.List;


/**
 * Created by employee on 10/22/15.
 */
public class TicketOfficeController {

    private final InputOptions input;

    private final Printer printer;

    public TicketOfficeController(InputOptions input, Printer printer) {
        this.input = input;
        this.printer = printer;
    }

    public void openTicketOffice()throws ParseException {
        FlightOptions flightOptions = input.readSearchOptions();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"bean.xml"}, true);
        FlightDao fDao = (FlightDao)context.getBean("flightDao");
        List<Flight> flightss = fDao.getAll();
        for(Flight f: flightss){
            printer.printFlightInfo(f);
            //System.out.println(f.getId() + " " + f.getName() + " " + f.getDateTime());
        }
        List<Flight> flights = fDao.findByDate(flightOptions.date, flightOptions.numberOfTicket, flightOptions.city);
       // Flight flight = ticketOffice.searchFlight();
     hasSearchFlight(flights);
        //printer.printTicket(flight.buyTicket());
    }

    public void hasSearchFlight(List<Flight> flight) {
        if (!flight.isEmpty()) {
            for ( Object o: flight){

                ((Flight)o).getId();
                Flight f = ((Flight)o);
                printer.printFlightInfo(f);
            }

        } else {
            printer.printSorryMessage();
        }
    }
}
