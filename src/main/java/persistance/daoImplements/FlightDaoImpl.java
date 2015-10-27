package persistance.daoImplements;

import core.daoInterface.FlightDao;
import core.entity.City;
import core.entity.Flight;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.ZoneId;

import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
@Service("flightDao")
@Transactional
public class FlightDaoImpl extends GenericDaoImpl<Flight,Integer> implements FlightDao {
    public FlightDaoImpl(Class<Flight> entityClass) {
        super(entityClass);
    }

    public List<Flight> findByDate(Date dateTime, int numberOfTiket, City city) {
        return this.sessionFactory.getCurrentSession()
                .createQuery(String.format("select f.id,f.dateTime,f.idCity, f.name,   f.numberOfPlace, f.numberOfReservedPlace" +
                                " from Flight f, City c\n" +
                        "where (f.dateTime > CURDATE())and" +
                        "(f.dateTime <= '%s')and" +
                        "((f.numberOfPlace - f.numberOfReservedPlace) >= %s )and" +
                        "(f.idCity = c.id)and(c.name = '%s')",
                        dateTime, numberOfTiket, city.getName())).list();

    }

}
