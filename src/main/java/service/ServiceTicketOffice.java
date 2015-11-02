package service;

import core.entity.City;
import core.entity.Flight;
import core.inputOutput.FlightOptions;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

/**
 * Created by employee on 10/28/15.
 */
public class ServiceTicketOffice {
    TicketOffice ticketOffice;

    ServiceTicketOffice(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public List<City> getAllCity(){
        return ticketOffice.cityDao.getAll();
    }
    public List<Flight> getAllFlights() throws ParseException {
        return ticketOffice.flightDao.getAll();
    }

    public List<Flight> findFlights(Date date, int numberOfTicket) {
        return ticketOffice.flightDao.findByDate(date, numberOfTicket);

    }
    public List<Flight> findFlightsToCity(int city) {
        return ticketOffice.flightDao.findByCity(city);

    }
    public List<Flight> findByDateCityPlace(Date date, int numberOfTicket, int idCity){
        return ticketOffice.flightDao.findByDateCityPlace(date, numberOfTicket, idCity);
    }

}
