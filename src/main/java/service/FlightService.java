package service;

import core.entity.Flight;

import java.sql.Date;
import java.util.List;

/**
 * Created by employee on 11/4/15.
 */
public interface FlightService {
    public List<Flight> getAllFlights();
    public void createFlight(int idCity, Date dateTime, String name,   int numberOfPlace);

    void deleteFlight(int id);
}
