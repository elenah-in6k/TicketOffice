package persistance.daoImplements;

import core.daoInterface.FlightDao;
import core.entity.City;
import core.entity.Flight;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
@Service("flightDao")
@Transactional
public class FlightDaoImpl extends GenericDaoImpl<Flight> implements FlightDao {
    public FlightDaoImpl() {
        super();
    }

    public List<Flight> findByDate(Date dateTime, int numberOfTicket, City city) {
        Query query = getSession()
                .createQuery("from core.entity.Flight where (dateTime > :today)and (dateTime <= :date)and ((numberOfPlace - numberOfReservedPlace) >= :tickets )and (City = :city)");
        query.setParameter("today", new Date());
        query.setParameter("date", dateTime);
        query.setParameter("tickets", numberOfTicket);
        query.setParameter("city", city);

        return query.list();
    }
}
