package servlet;
import core.entity.City;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.web.context.support.WebApplicationContextUtils;
import service.ServiceTicketOffice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by employee on 10/30/15.
 */
public class CityServlet extends GeneralServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<City> cities = service.getAllCity();

        out.print(printer.printCity(cities));
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }

}