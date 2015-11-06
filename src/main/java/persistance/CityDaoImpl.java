package persistance;

import core.entity.City;
import core.dao.CityDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Алена on 26.10.2015.
 */
@Repository("cityDao")
public class CityDaoImpl extends GenericDaoImpl<City> implements CityDao {
    public CityDaoImpl() {
        super();
    }

    public List<City> findByName(String name) {
        return null;
    }
}
