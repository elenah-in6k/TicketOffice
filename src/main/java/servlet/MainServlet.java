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
 * Created by employee on 11/2/15.
 */
public class MainServlet  extends GeneralServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();


        out.print(getHomeHtml());
    }

    private String getHomeHtml() {
        String out ="";
        out +="<html>"+
        "<head>"+
        "<title>Ticket Office</title>"+
        "</head>"+
        "<body>"+
        "<a href=\"hello\">Hello;)))</a>"+
              "<br> <br>"+
        "<a href=\"city\">Get all cities</a>"+
                "<br> <br>"+
        "<a href=\"flight\">Get all flights</a>"+
                "<br> <br>"+
        "<a href=\"searchFlight\">Search flights</a>"+
        "</body>"+
        "</html>";
        return out;
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }

}