package core.inputOutput;

import core.entity.City;
import core.entity.Flight;
import core.entity.Ticket;

import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public class HtmlPrinter implements Printer {


    @Override
    public String printFlight(List<Flight> flights) {
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

    @Override
    public String printCity(List<City> cities) {
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

    @Override
    public void printHelloMessage() {

    }

    @Override
    public void printInputDateMessage() {

    }

    @Override
    public void printInputTicketMessage() {

    }

    @Override
    public void printInputCityMessage() {

    }

    @Override
    public void printSorryMessage() {

    }

    @Override
    public void printTicket(Ticket ticket) {

    }

    @Override
    public void printFlightInfo(Flight flight) {

    }

}
