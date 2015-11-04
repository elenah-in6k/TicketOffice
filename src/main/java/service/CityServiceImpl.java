package service;

import core.daoInterface.CityDao;
import core.entity.City;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by employee on 11/4/15.
 */
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;
    @Override
    public List<City> getAllCity(){
        return cityDao.getAll();
    }

    @Override
    public void createCity(String name){
        cityDao.create(new City(name));
    }
}
