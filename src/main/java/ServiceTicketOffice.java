import core.daoInterface.CityDao;
import core.daoInterface.FlightDao;
import core.entity.City;
import core.entity.Flight;
import core.inputOutput.FlightOptions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.List;

/**
 * Created by employee on 10/28/15.
 */
public class ServiceTicketOffice {
    TicketOffice ticketOffice;

    ServiceTicketOffice(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public List<City> getAllCity(){
        return ticketOffice.cityDao.getAll();
    }
    public List<Flight> getAllFlights() throws ParseException {
        return ticketOffice.flightDao.getAll();
    }

    public List<Flight> findFlights(FlightOptions flightOptions) {
        return ticketOffice.flightDao.findByDate(flightOptions.date, flightOptions.numberOfTicket, flightOptions.city);

    }
}
