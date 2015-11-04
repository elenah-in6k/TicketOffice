package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CityServiceImpl;
import service.FlightServiceImpl;

import javax.servlet.ServletRequest;

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping(value = "/city")
public class CityController extends BaseController {

    @Autowired
    CityServiceImpl service;

    @RequestMapping( method = RequestMethod.GET)
    public String printCity(ModelMap model) {
        model.addAttribute("name", "City");
        model.addAttribute("cities", service.getAllCity());

        return "city";
    }

    @RequestMapping( method = RequestMethod.POST)
    public String printAddCity(ModelMap model, ServletRequest request ) {
        String nameCity = request.getParameter("nameCity");
        service.createCity(nameCity);
        model.addAttribute("ifAdd", "City add successfully!");
        return printCity(model);
    }
}
