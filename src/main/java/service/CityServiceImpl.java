package service;

import core.dao.CityDao;
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

    @Override
    public boolean deleteCity(int id) {
        boolean flag = false;
        try{
        cityDao.delete(readCity(id));
            flag = true;
        }
        catch(Exception e){

        }
        return flag;
    }

    @Override
    public City readCity(int id) {
        return cityDao.read(id);
    }


}
