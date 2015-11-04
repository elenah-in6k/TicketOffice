package controllers;

import core.entity.Flight;
import core.inputOutput.HtmlPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ServiceBaseImpl;

import javax.servlet.ServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by employee on 11/3/15.
 */
@Controller
public class OfficeController{
    ServiceBaseImpl service;

    protected Date getDate(String date1) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateU = null;
        try {
            dateU = sdf1.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(dateU.getTime());
    }

    @Autowired
    public void init(ServiceBaseImpl service) {
        this.service = service;

    }
    @RequestMapping(value = "/flight", method = RequestMethod.POST)
    public String printAddFlight(ModelMap model, ServletRequest request )   {
        int idCity = Integer.parseInt(request.getParameter("idCity"));
        String name = request.getParameter("name");
        Date date = getDate(request.getParameter("date"));
        int numberOfPlace = Integer.parseInt(request.getParameter("numberOfPlace"));
             service.createFlight(idCity, date, name, numberOfPlace);
        model.addAttribute("ifAdd", "Flight add successfully");
        return printFlight(model);
    }

    @RequestMapping(value = "/flight", method = RequestMethod.GET)
    public String printFlight(ModelMap model) {
        model.addAttribute("name", "Flight");
        model.addAttribute("flight",service.getAllFlights());
         model.addAttribute("cities", service.getAllCity());

        return "flight";
    }
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String printCity(ModelMap model) {
        model.addAttribute("name", "City");
        model.addAttribute("cities", service.getAllCity());

        return "city";
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public String printAddCity(ModelMap model, ServletRequest request ) {
        String nameCity = request.getParameter("nameCity");
        service.createCity(nameCity);
        model.addAttribute("ifAdd", "City add successfully!");
        return printCity(model);
    }



    @RequestMapping(value = "/searchFlight", method = RequestMethod.GET)
    public String searchFlight(ModelMap model) {
        model.addAttribute("name", "Search flight");
        model.addAttribute("cities", service.getAllCity());

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
