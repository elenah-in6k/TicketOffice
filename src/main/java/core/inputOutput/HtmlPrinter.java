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
    private final String openHtmlTag = "<html>";
    private final String closeHtmlTag = "</html>";

    public String printHomeLink(){
       return "<h3><a href=\"/\">Go home</a></h3>";
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
    public String printFlight(List<Flight> flights) {

        String outHtml = "<table width=\"100%\">";

        if (flights.size() != 0) {
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
        } else {
            outHtml += "Flights don\'t found";
        }
        outHtml += "</table>";


        return outHtml;
    }

    @Override
    public void printTicket(Ticket ticket) {

    }

    @Override
    public void printFlightInfo(Flight flight) {

    }

    public String getFormSearch(List<City> cities) {
        String outHtml = openHtmlTag + "<body>";
        outHtml += "<form method=\"GET\" action=\"/searchResult\">";
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
        outHtml += "<input type=\"submit\" name=\"searchFlight\" value=\"searchAllOptions\">";
        outHtml += "</form></body>" + closeHtmlTag;
        return outHtml;
    }

    public String getAddFlightForm(List<City> cities) {
        String outHtml = openHtmlTag + "<body>";
        outHtml += "<form method=\"POST\" action=\"/flight\">";
        outHtml += "<label for=\"idCity\">City: </label>";
        outHtml += "<select name=\"idCity\" id=\"idCity\">";
        for (City city : cities) {
            outHtml += "<option value=\"" + city.getId() + "\">" + city.getName() + "</option>";
        }
        outHtml += "</select>";
        outHtml += "<br> <br>";
        outHtml += "<label for=\"name\"> Name: </label>";
        outHtml += "<input type=\"text\" name=\"name\" id=\"name\">";
        outHtml += "<br> <br>";
        outHtml += "<label for=\"date\"> Date (yyyy-MM-dd): </label>";
        outHtml += "<input type=\"text\" name=\"date\" id=\"date\">";
        outHtml += "<br> <br>";
        outHtml += "<label for=\"numberOfPlace\"> numberOfPlace: </label>";
        outHtml += "<input type=\"text\" name=\"numberOfPlace\" id=\"numberOfPlace\">";
        outHtml += "<br> <br>";

        outHtml += "<input type=\"submit\" name=\"addFlight\" value=\"addFlight\">";
        outHtml += "</form></body>" + closeHtmlTag;
        return outHtml;
    }

    public String getAddFormCity(){
        String outHtml = openHtmlTag + "<body>";
        outHtml += "<form method=\"POST\" action=\"/city\">";
        outHtml += "<label for=\"nameCity\"> Enter name city: </label>";
        outHtml += "<input type=\"text\" name=\"nameCity\" id=\"nameCity\">";
        outHtml += "<input type=\"submit\" name=\"addCity\" value=\"addCity\">";
        outHtml += "</form></body>" + closeHtmlTag;
        return outHtml;
    }

    @Override
    public String printCity(List<City> cities) {
        String outHtml = "<table>";
        if (cities.size() != 0) {
            for (City city : cities) {
                outHtml += "<tr>";
                outHtml += "<td>" + city.getName() + "</td>";
                outHtml += "</tr>";
            }
        } else {
            outHtml += "City don\'t found";
        }
        outHtml += "</table>";


        return outHtml;
    }

}
