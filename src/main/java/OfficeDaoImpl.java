import ticketoffice.Flight;

import java.util.List;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by employee on 10/23/15.
 */

@Repository
public class OfficeDaoImpl implements OfficeDao  {

    @PersistenceContext
    private EntityManager em;


    public void save(CityN content) {
        em.persist(content);
    }

    public List<CityN> getAll() {
        return em.createQuery("from CityN", CityN.class).getResultList();
    }

}
