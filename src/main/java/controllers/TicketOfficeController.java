package controllers;


import core.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CityService;
import service.CityServiceImpl;
import service.TicketOfficeService;
import service.TicketOfficeServiceImpl;

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
    TicketOfficeServiceImpl service;

    @Autowired
    CityServiceImpl cityService;

    @RequestMapping( method = RequestMethod.GET)
    public String searchFlight(ModelMap model) {

        model.addAttribute("cities", cityService.getAllCity());

        return "searchFlight";
    }

    @RequestMapping(value = "/result/", method = RequestMethod.GET)
    public String printSearchFlight(ModelMap model,
                                    @RequestParam int idCity,
                                    @RequestParam String date,
                                    @RequestParam int numberOfPlace)  {
        Date dateF = getDate(date);
        List<Flight> flights = service.findByDateCityPlace(dateF, numberOfPlace, idCity);
        model.addAttribute("searchFlight", flights);

        return "result";
    }
}
