package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.CityServiceImpl;
import service.FlightServiceImpl;

import java.sql.Date;

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping(value = "/flights")
public class FlightController extends BaseController {
    @Autowired
    FlightServiceImpl flightService;
    @Autowired
    CityServiceImpl service;
    @RequestMapping( method = RequestMethod.POST)
    public String printAddFlight(
            ModelMap model,
            @RequestParam int idCity,
            @RequestParam String name,
            @RequestParam String date,
            @RequestParam int numberOfPlace
    )   {
        Date dateS = getDate(date);
        flightService.createFlight(idCity, dateS, name, numberOfPlace);
        model.addAttribute("ifAdd", "Flight add successfully");
        return printFlight(model);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printFlight(ModelMap model) {
        model.addAttribute("flight", flightService.getAllFlights());
        model.addAttribute("cities", service.getAllCity());

        return "flights";
    }
    @RequestMapping(value = "/delete/", method = RequestMethod.POST)
    public String deleteCity(@RequestParam int idFlight) {
        flightService.deleteFlight(idFlight);
        return "redirect:/flights";
    }
}
