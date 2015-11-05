package service;

import core.entity.Flight;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by employee on 11/4/15.
 */
@Service
public interface FlightService {
    public List<Flight> getAllFlights();
    public void createFlight(int idCity, Date dateTime, String name,   int numberOfPlace);

    void deleteFlight(int id);
}
