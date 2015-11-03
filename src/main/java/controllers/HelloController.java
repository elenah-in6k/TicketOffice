package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("hello", "Hello dear!");
        model.addAttribute("city", "<a href=\"city\">Get all cities</a>");
        model.addAttribute("flight", "<a href=\"flight\">Get all flights</a>");
        model.addAttribute("searchFlight", "<a href=\"searchFlight\">Search flights</a>");
        return "hello";
    }
}