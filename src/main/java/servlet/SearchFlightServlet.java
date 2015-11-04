package servlet;

import core.entity.Flight;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public class SearchFlightServlet extends GeneralServlet{


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

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
        out.print(printer.printFlight(flights));

    }

}