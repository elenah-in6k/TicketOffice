package service;

import core.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by employee on 11/4/15.
 */
@Service
public interface CityService {

    public List<City> getAllCity();

    public void createCity(String name);

    public boolean deleteCity(int id);

    City readCity(int id);
}
