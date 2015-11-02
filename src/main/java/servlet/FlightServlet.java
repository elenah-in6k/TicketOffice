package servlet;

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
public class FlightServlet extends HttpServlet {
    ServiceTicketOffice service;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        service = (ServiceTicketOffice) context.getBean("service");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<Flight> flights = null;
        try {
            flights = service.getAllFlights();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        out.print(getFlightsTable(flights));

    }

    public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {

    }

    private String getFlightsTable(List<Flight> flights) {
        String outHtml = "<html>" + "<head>" +
                "<title>Flights</title>" +
                "</head>" +
                "<body>" +
                "<h1>Flights</h1>" + "<table width=\"100%\">";
        outHtml += "<tr>";
        outHtml += "<td>" + "Name" + "</td>";
        outHtml += "<td>" + "DateTime" + "</td>";
        outHtml += "<td>" + "NumberOfPlace" + "</td>";
        outHtml += "<td>" + "NumberOfEmptyPlaces" + "</td>";
        outHtml += "<td>" + "CityName" + "</td>";
        outHtml += "</tr>";
        for (Flight flight : flights) {
            outHtml += "<tr>";
            outHtml += "<td>" + flight.getName() + "</td>";
            outHtml += "<td>" + flight.getDateTime() + "</td>";
            outHtml += "<td>" + flight.getNumberOfPlace() + "</td>";
            outHtml += "<td>" + flight.getNumberOfEmptyPlaces() + "</td>";
            outHtml += "<td>" + flight.getCity().getName() + "</td>";
            outHtml += "</tr>";
        }
        outHtml += "</table>" +
                "</body>" +
                "</html>";


        return outHtml;
    }
}