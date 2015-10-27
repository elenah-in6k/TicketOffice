package persistance.daoImplements;

import core.entity.Flight;
import core.daoInterface.FlightDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public List<Flight> findByDate(LocalDateTime dateTime) {
        return this.sessionFactory.getCurrentSession()
                .createQuery(String.format("from Flight\n" +
                        "where (dataTime > CURDATE())and(dataTime <= '%s')", dateTime.toLocalDate())).list();
    }

}
