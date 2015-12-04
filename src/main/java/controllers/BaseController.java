package controllers;

import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by employee on 11/4/15.
 */
@Controller
abstract public class BaseController  {
    public Date getDate(String date1) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateU = null;
        try {
            dateU = sdf1.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(dateU.getTime());
    }
}
