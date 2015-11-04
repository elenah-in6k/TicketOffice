package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.BaseServiceImpl;
import service.CityServiceImpl;
import service.FlightServiceImpl;

import javax.servlet.ServletRequest;
import java.sql.Date;

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping(value = "/flight")
public class FlightController extends BaseController {
    @Autowired
    FlightServiceImpl flightService;
    @Autowired
    CityServiceImpl service;
    @RequestMapping( method = RequestMethod.POST)
    public String printAddFlight(ModelMap model, ServletRequest request )   {
        int idCity = Integer.parseInt(request.getParameter("idCity"));
        String name = request.getParameter("name");
        Date date = getDate(request.getParameter("date"));
        int numberOfPlace = Integer.parseInt(request.getParameter("numberOfPlace"));
        flightService.createFlight(idCity, date, name, numberOfPlace);
        model.addAttribute("ifAdd", "Flight add successfully");
        return printFlight(model);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printFlight(ModelMap model) {
        model.addAttribute("name", "Flight");
        model.addAttribute("flight", flightService.getAllFlights());
        model.addAttribute("cities", service.getAllCity());

        return "flight";
    }
}
