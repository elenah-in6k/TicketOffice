package core.inputOtpute;

import core.entity.City;
import core.entity.Flight;
import ticketoffice.FlightImpl;

import java.time.LocalDate;

/**
 * Created by employee on 10/21/15.
 */
public class FlightOptions {
    LocalDate date;
    int numberOfTicket;
    public City city;
    public FlightOptions(LocalDate date, int numberOfTicket, City city){
        this.date = date;
        this.numberOfTicket = numberOfTicket;
        this.city = city;
    }

    public boolean test(Flight flight) {
        return (flight.getIdCity() == city.getId())&
        (flight.isNearDate(date))&
        (flight.getNumberOfEmptyPlaces() >= numberOfTicket);
   }

    @Override
    public String toString() {
        return String.format("%s %s", city.getName(), date);
    }
}
