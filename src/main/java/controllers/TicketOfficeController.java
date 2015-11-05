package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CityService;
import service.TicketOfficeService;


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

}
