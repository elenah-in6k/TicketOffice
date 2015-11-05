package service;

import core.dao.FlightDao;
import core.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

/**
 * Created by employee on 11/4/15.
 */
public class TicketOfficeServiceImpl implements TicketOfficeService {
    @Autowired
    FlightDao flightDao;
    public List<Flight> findFlightsToCity(int city) {
        return flightDao.findByCity(city);

    }

    public List<Flight> findByDateCityPlace(Date date, int numberOfTicket, int idCity){
        return flightDao.findByDateCityPlace(date, numberOfTicket, idCity);
    }
}
