package core.dao;

import core.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Алена on 26.10.2015.
 */
@Repository
public interface CityDao extends GenericDao<City>  {
    List<City> findByName(String name);

}
