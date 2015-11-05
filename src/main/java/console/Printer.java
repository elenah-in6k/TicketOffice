package console;

import core.entity.City;
import core.entity.Flight;
import core.entity.Ticket;

import java.util.List;


/**
 * Created by employee on 10/22/15.
 */
public interface Printer {
    void printHelloMessage();
    void printInputDateMessage();
    void printInputTicketMessage();
    void printInputCityMessage();
    void printSorryMessage();
    void printTicket(Ticket ticket);
    void printFlightInfo(Flight flight);
    String printFlight(List<Flight> flight);
    String printCity(List<City> cities);

}
