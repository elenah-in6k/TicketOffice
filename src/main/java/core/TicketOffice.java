package core;

import org.springframework.stereotype.Service;
import persistance.CityDaoImpl;
import persistance.FlightDaoImpl;
import persistance.TicketDaoImpl;

/**
 * Created by employee on 10/29/15.
 */
@Service
public class TicketOffice {
    public CityDaoImpl cityDao;
    public FlightDaoImpl flightDao;
    public TicketDaoImpl ticketDao;
    public TicketOffice(CityDaoImpl cityDao, FlightDaoImpl flightDao, TicketDaoImpl ticketDao){
        this.cityDao = cityDao;
        this.flightDao = flightDao;
        this.ticketDao = ticketDao;
    }

}
