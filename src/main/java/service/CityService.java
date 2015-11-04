package service;

import core.entity.City;

import java.util.List;

/**
 * Created by employee on 11/4/15.
 */
public interface CityService {

    public List<City> getAllCity();

    public void createCity(String name);
}
