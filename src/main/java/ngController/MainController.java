package ngController;

import core.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CityServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ticketOffice")
public class MainController {
    @Autowired
    CityServiceImpl cityService;

    public static List<City> cities = new ArrayList<City>();
    @RequestMapping(value = "/")
    public String[] index() {
        return new String[] {"first", "second", "ababababbqaba"};
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<City> cities() {
        List<City> allCity = cityService.getAllCity();
        return allCity;
    }

    @RequestMapping(value = "/cities/", method = RequestMethod.POST)
    public void addCity(@RequestBody City city) {
        cityService.createCity(city.getName());

    }

    @RequestMapping(value = "/cities/{id}", method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable("id") Integer id) {
        cityService.deleteCity(id);

    }
}