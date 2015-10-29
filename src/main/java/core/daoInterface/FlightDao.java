package core.daoInterface;

import core.entity.City;
import core.entity.Flight;

import java.util.Date;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public interface FlightDao extends GenericDao<Flight> {
    List<Flight> findByDate(Date dateTime, int numberOfPlace, City city);

}
