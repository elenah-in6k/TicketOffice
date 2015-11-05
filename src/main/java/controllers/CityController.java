package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CityServiceImpl;

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping(value = "/cities")
public class CityController extends BaseController {
    String  exception = "";
    @Autowired
    CityServiceImpl service;


    @RequestMapping( method = RequestMethod.GET)
    public String printCity(ModelMap model) {
        model.addAttribute("cities", service.getAllCity());
        model.addAttribute("exception", exception);
        return "cities";
    }

    @RequestMapping( method = RequestMethod.POST)
    public String printAddCity(ModelMap model, @RequestParam String nameCity ) {
        service.createCity(nameCity);
        model.addAttribute("ifAdd", "City add successfully!");
        exception = "";
        return printCity(model);
    }
    @RequestMapping(value = "/delete/", method = RequestMethod.POST)
    public String deleteCity(@RequestParam int idCity, ModelMap model) {

        if (!service.deleteCity(idCity)) {
            exception = "You can't delete!";
        }else{
            exception = "";
        }
        model.addAttribute("exception", exception);
        return "redirect:/cities";
    }
}
