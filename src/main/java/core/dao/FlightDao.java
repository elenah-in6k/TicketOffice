package core.dao;

import core.entity.Flight;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
@Repository
public interface FlightDao extends GenericDao<Flight> {
    List<Flight> findByDate(Date dateTime, int numberOfPlace);
    List<Flight> findByCity(int idCity);
    public List<Flight> findByDateCityPlace(Date dateTime, int numberOfTicket, int idCity);

}
