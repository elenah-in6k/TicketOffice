package servlet;

import core.entity.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

        out.print(printer.getFormSearch(cities));

    }

    public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {

    }
}