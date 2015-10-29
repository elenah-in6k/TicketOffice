import core.daoInterface.CityDao;
import core.daoInterface.FlightDao;
import core.daoInterface.TicketDao;
import persistance.daoImplements.CityDaoImpl;
import persistance.daoImplements.FlightDaoImpl;
import persistance.daoImplements.TicketDaoImpl;

/**
 * Created by employee on 10/29/15.
 */
public class TicketOffice {
    CityDaoImpl cityDao;
    FlightDaoImpl flightDao;
    TicketDaoImpl ticketDao;
    TicketOffice(CityDaoImpl cityDao, FlightDaoImpl flightDao, TicketDaoImpl ticketDao){
        this.cityDao = cityDao;
        this.flightDao = flightDao;
        this.ticketDao = ticketDao;
    }

}
