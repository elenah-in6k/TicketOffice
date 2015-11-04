package service;

import core.entity.City;
import core.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

/**
 * Created by employee on 10/28/15.
 */
public class ServiceBaseImpl  {

    @Autowired
    TicketOffice ticketOffice;

    public List<City> getAllCity(){
        return ticketOffice.cityDao.getAll();
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
    public void createCity(String name){
        ticketOffice.cityDao.create(new City(name));
    }

    public void createFlight(int idCity, Date dateTime, String name,   int numberOfPlace){
        City city = ticketOffice.cityDao.read(idCity);
        ticketOffice.flightDao.create(new Flight(dateTime, name, numberOfPlace, city));
    }
    public List<Flight> getAllFlights() {
        return ticketOffice.flightDao.getAll();
    }


}
