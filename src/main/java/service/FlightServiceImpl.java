package service;

import core.TicketOffice;
import core.dao.FlightDao;
import core.entity.City;
import core.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by employee on 11/4/15.
 */
@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private TicketOffice ticketOffice;
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

    @Override
    public void deleteFlight(int id) {
        flightDao.delete(flightDao.read(id));
    }
}
