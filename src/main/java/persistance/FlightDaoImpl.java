package persistance;

import core.dao.FlightDao;
import core.entity.Flight;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
@Repository("flightDao")
@Transactional
public class FlightDaoImpl extends GenericDaoImpl<Flight> implements FlightDao {
    public FlightDaoImpl() {
        super();
    }

    public List<Flight> findByDate(Date dateTime, int numberOfTicket) {
        Query query = getSession()
                .createQuery("from core.entity.Flight where (dateTime > :today)and (dateTime <= :date)and ((numberOfPlace - numberOfReservedPlace) >= :tickets )");
        query.setParameter("today", new Date());
        query.setParameter("date", dateTime);
        query.setParameter("tickets", numberOfTicket);
      //  query.setParameter("idCity", idCity);
        return query.list();
    }
    public List<Flight> findByCity(int idCity){
        Query query = getSession()
                .createQuery("from core.entity.Flight where (idCity = :idCity)");
        query.setParameter("idCity", idCity);
        return query.list();
    }

    public List<Flight> findByDateCityPlace(Date dateTime, int numberOfTicket, int idCity) {
        Query query = getSession()
                .createQuery("from core.entity.Flight where (dateTime > :today)and (dateTime <= :date)and ((numberOfPlace - numberOfReservedPlace) >= :tickets )and(idCity = :idCity)");
        query.setParameter("today", new Date());
        query.setParameter("date", dateTime);
        query.setParameter("tickets", numberOfTicket);
        query.setParameter("idCity", idCity);
        return query.list();
    }
}
