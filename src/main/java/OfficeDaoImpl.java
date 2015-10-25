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


    public void save(City content) {
        em.persist(content);
    }

    public List<City> getAll() {
        return em.createQuery("from City", City.class).getResultList();
    }

}
