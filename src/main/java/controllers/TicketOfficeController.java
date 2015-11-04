package controllers;

import core.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CityService;
import service.CityServiceImpl;
import service.TicketOfficeService;

import javax.servlet.ServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping(value = "/searchFlight")
public class TicketOfficeController extends BaseController {
    @Autowired
    TicketOfficeService service;
    @Autowired
    CityService cityService;

    @RequestMapping( method = RequestMethod.GET)
    public String searchFlight(ModelMap model) {
        model.addAttribute("name", "Search flight");
        model.addAttribute("cities", cityService.getAllCity());

        return "searchFlight";
    }

    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public String printSearchFlight(ModelMap model, ServletRequest request)  {
        model.addAttribute("name", "Searched flights");

        int idCity = Integer.parseInt(request.getParameter("idCity"));
        Date date = getDate(request.getParameter("date"));
        int numberOfPlace = Integer.parseInt(request.getParameter("numberOfPlace"));

        List<Flight> flights = service.findByDateCityPlace(date, numberOfPlace, idCity);
        model.addAttribute("searchFlight", flights);

        return "searchResult";
    }

}
