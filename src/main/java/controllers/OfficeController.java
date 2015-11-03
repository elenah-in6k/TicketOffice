package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by employee on 11/3/15.
 */
@Controller
public class OfficeController {
    @RequestMapping(value = "/city", method = RequestMethod.GET)

    public String printCity(ModelMap model) {
        model.addAttribute("name", "City");
        model.addAttribute("city", "cityHaHaHa!");
        return "city";
    }
}
