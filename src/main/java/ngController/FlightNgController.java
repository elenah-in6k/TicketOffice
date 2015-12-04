package ngController;

import core.entity.City;
import core.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CityServiceImpl;
import service.FlightServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 12/4/15.
 */
@RestController
@RequestMapping(value = "/ticketOffice/flights")
public class FlightNgController {
    @Autowired
    CityServiceImpl cityService;

    @Autowired
    FlightServiceImpl flightService;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<City> getCities() {
        List<City> allCity = cityService.getAllCity();
        return allCity;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Flight> getFlights() {
        return  flightService.getAllFlights();
    }

    @RequestMapping( method = RequestMethod.POST)
    public void addFlight(@RequestBody Flight flight) {
        flightService.createFlight(flight.getCity().getId(), flight.getDateTime(), flight.getName(), flight.getNumberOfPlace());

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFlight(@PathVariable("id") Integer id) {
        flightService.deleteFlight(id);

    }
}
