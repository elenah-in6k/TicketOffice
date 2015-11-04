package service;

import core.entity.City;
import core.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

/**
 * Created by employee on 10/28/15.
 */
public class BaseServiceImpl {

    @Autowired
    TicketOffice ticketOffice;

    public List<Flight> getAllFlights() {
        return ticketOffice.flightDao.getAll();
    }

    public void createFlight(int idCity, Date dateTime, String name,   int numberOfPlace){
        City city = ticketOffice.cityDao.read(idCity);
        ticketOffice.flightDao.create(new Flight(dateTime, name, numberOfPlace, city));
    }

    //////////////////////////////////

    public List<City> getAllCity(){
        return ticketOffice.cityDao.getAll();
    }

    public void createCity(String name){
        ticketOffice.cityDao.create(new City(name));
    }

    ///////////////////////////////////

    public List<Flight> findFlightsToCity(int city) {
        return ticketOffice.flightDao.findByCity(city);

    }

    public List<Flight> findByDateCityPlace(Date date, int numberOfTicket, int idCity){
        return ticketOffice.flightDao.findByDateCityPlace(date, numberOfTicket, idCity);
    }


}
