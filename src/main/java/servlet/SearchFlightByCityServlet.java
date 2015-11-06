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
public class SearchFlightByCityServlet extends GeneralServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        int idCity =  Integer.parseInt(request.getParameter("idCity"));

        List<Flight> flights = service.findFlightsToCity(idCity);
        out.print(printer.printFlight(flights));



    }
}
