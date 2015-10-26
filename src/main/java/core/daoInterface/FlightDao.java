package core.daoInterface;

import core.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public interface FlightDao extends GenericDao<Flight, Integer> {
    List<Flight> findByDate(LocalDateTime dateTime);
}
