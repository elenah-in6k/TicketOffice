package core.inputOutput;

import core.entity.City;
import core.entity.Flight;
import core.entity.Ticket;

import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public class HtmlPrinter implements Printer {


    private final String openRowTag = "<tr>";
    private final String closeRowTag = "</tr>";
    private final String openCellTag = "<td>";
    private final String closeCellTag = "</td>";
    private final String openHtmlTag = "<html>";
    private final String closeHtmlTag = "</html>";

    @Override
    public String printFlight(List<Flight> flights) {
        String outHtml = openHtmlTag + "<head>" +
                "<title>Flights</title>" +
                "</head>" +
                "<body>" +
                "<h1>Flights</h1>" + "<table width=\"100%\">";
        outHtml += openRowTag;
        outHtml += openCellTag + "Name" + closeCellTag;
        outHtml += openCellTag + "DateTime" + closeCellTag;
        outHtml += openCellTag + "NumberOfPlace" + closeCellTag;
        outHtml += openCellTag + "NumberOfEmptyPlaces" + closeCellTag;
        outHtml += openCellTag + "CityName" + closeCellTag;
        outHtml += closeRowTag;
        for (Flight flight : flights) {
            outHtml += openRowTag;
            outHtml += openCellTag + flight.getName() + closeCellTag;
            outHtml += openCellTag + flight.getDateTime() + closeCellTag;
            outHtml += openCellTag + flight.getNumberOfPlace() + closeCellTag;
            outHtml += openCellTag + flight.getNumberOfEmptyPlaces() + closeCellTag;
            outHtml += openCellTag + flight.getCity().getName() + closeCellTag;
            outHtml += closeRowTag;
        }
        outHtml += "</table>" +
                "</body>" +
                closeHtmlTag;


        return outHtml;
    }

    @Override
    public String printCity(List<City> cities) {
        String outHtml = openHtmlTag +"<head>"+
                "<title>City</title>"+
                "</head>"+
                "<body>" +
                "<h1>City</h1>"+"<table>";
        for (City city : cities) {
            outHtml += openRowTag;
            outHtml += openCellTag +city.getName()+ closeCellTag;
            outHtml += closeRowTag;
        }
        outHtml +="</table>"+
                "</body>" +
                closeHtmlTag;


        return outHtml;
    }

    public String getForm( List<City> cities){
        String outHtml = openHtmlTag + "<body>";
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
        outHtml += "</form></body>" + closeHtmlTag;
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