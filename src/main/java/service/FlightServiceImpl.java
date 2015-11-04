package service;

import core.daoInterface.FlightDao;
import core.entity.City;
import core.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

/**
 * Created by employee on 11/4/15.
 */
public class FlightServiceImpl implements FlightService {
    @Autowired
    TicketOffice ticketOffice;
    @Autowired
    FlightDao flightDao;

    @Override
    public List<Flight> getAllFlights() {
        return flightDao.getAll();
    }

    @Override
     public void createFlight(int idCity, Date dateTime, String name,   int numberOfPlace){
        City city = ticketOffice.cityDao.read(idCity);
        flightDao.create(new Flight(dateTime, name, numberOfPlace, city));
    }
}
