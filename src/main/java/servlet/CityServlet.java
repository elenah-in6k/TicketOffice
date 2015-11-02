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
public class CityServlet extends HttpServlet {
    ServiceTicketOffice service;
    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        service = (ServiceTicketOffice) context.getBean("service");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<City> cities = service.getAllCity();

        out.print(getCitiesTable(cities));
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
    private String getCitiesTable(List<City> cities){
        String outHtml = "<html>" +"<head>"+
                "<title>City</title>"+
                "</head>"+
                "<body>" +
                "<h1>City</h1>"+"<table>";
        for (City city : cities) {
            outHtml += "<tr>";
            outHtml += "<td>"+city.getName()+"</td>";
            outHtml += "</tr>";
        }
        outHtml +="</table>"+
                "</body>" +
                "</html>";


        return outHtml;
    }
}