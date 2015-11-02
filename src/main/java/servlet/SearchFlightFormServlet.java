package servlet;

import core.entity.City;
import core.entity.Flight;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.ServiceTicketOffice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public class SearchFlightFormServlet extends GeneralServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        List<City> cities = service.getAllCity();

        out.print(getForm(cities));

    }

    public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {

    }
    private String getForm( List<City> cities){
        String outHtml = "<html>" + "<body>";
        outHtml += "<form method=\"GET\" action=\"/search\">";
        outHtml += "<label for=\"idCity\">City: </label>";
        outHtml += "<select name=\"idCity\" id=\"idCity\">";
        for (City city : cities) {
            outHtml += "<option value=\"" + city.getId() + "\">" + city.getName() + "</option>";
        }
        outHtml += "</select>";
        outHtml += "<br> <br>";
        outHtml += "<label for=\"date\"> Date (yyyy-MM-dd): </label>";
        outHtml += "<input type=\"text\" name=\"date\" id=\"date\">";
        outHtml += "<br> <br>";
        outHtml += "<label for=\"numberOfPlace\"> numberOfPlace: </label>";
        outHtml += "<input type=\"text\" name=\"numberOfPlace\" id=\"numberOfPlace\">";
        outHtml += "<br> <br>";
//        outHtml += "<button type=\"submit\" method=\"GET\" action = \"/searchByCity\" form >searchByCity</button>";
                outHtml += "<input type=\"submit\" name=\"searchFlight\" value=\"searchAllOptions\">";
        outHtml += "</form></body>" + "</html>";
        return outHtml;
    }
}