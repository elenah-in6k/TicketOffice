package core.daoInterface;

import core.entity.City;

import java.util.List;

/**
 * Created by Алена on 26.10.2015.
 */
public interface CityDao extends GenericDao<City>  {
    List<City> findByName(String name);

}
