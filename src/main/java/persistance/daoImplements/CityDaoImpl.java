package persistance.daoImplements;

import core.entity.City;
import core.daoInterface.CityDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Алена on 26.10.2015.
 */
@Service("cityDao")
public class CityDaoImpl extends GenericDaoImpl<City,Integer> implements CityDao {
    public CityDaoImpl(Class<City> entityClass) {
        super(entityClass);
    }

    public List<City> findByName(String name) {
        return null;
    }
}
