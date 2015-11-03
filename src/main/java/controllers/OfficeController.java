package controllers;

import core.entity.Flight;
import core.inputOutput.HtmlPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ServiceTicketOffice;

import javax.servlet.ServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by employee on 11/3/15.
 */
@Controller
public class OfficeController {
    ServiceTicketOffice service;
    HtmlPrinter printer;

    @Autowired
    public OfficeController( ServiceTicketOffice service,
            HtmlPrinter printer){
        this.service =  service;
        this.printer = printer;

    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String printCity(ModelMap model) {
        model.addAttribute("name", "City");
        model.addAttribute("city", printer.printCity(service.getAllCity()));
        return "city";
    }

    @RequestMapping(value = "/flight", method = RequestMethod.GET)
    public String printFlight(ModelMap model) throws ParseException {
        model.addAttribute("name", "Flight");
        model.addAttribute("flight", printer.printFlight(service.getAllFlights()));
        return "flight";
    }
    @RequestMapping(value = "/searchFlight", method = RequestMethod.GET)
    public String searchFlight(ModelMap model) {
        model.addAttribute("name", "Search flight");
        model.addAttribute("searchFlight", printer.getForm(service.getAllCity()));
        return "searchFlight";
    }

    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public String printSearchFlight(ModelMap model, ServletRequest request) {
        model.addAttribute("name", "Searched flights");
        /////////////////////////////////////////////////////////////////////////
        int idCity =  Integer.parseInt(request.getParameter("idCity"));
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateU = null;
        try {
            dateU = sdf1.parse(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date = new java.sql.Date(dateU.getTime());
        int numberOfPlace = Integer.parseInt(request.getParameter("numberOfPlace"));

        List<Flight> flights = service.findByDateCityPlace(date, numberOfPlace, idCity);

        /////////////////////////////////////////////////////
        model.addAttribute("searchFlight", printer.printFlight(flights));
        return "searchResult";
    }

}
