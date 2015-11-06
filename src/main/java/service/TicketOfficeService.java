package service;

import core.entity.Flight;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by employee on 11/4/15.
 */
@Service
public interface TicketOfficeService {
    public List<Flight> findFlightsToCity(int city);

    public List<Flight> findByDateCityPlace(Date date, int numberOfTicket, int idCity);
}
