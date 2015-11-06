package core.inputOutput;

import core.entity.City;

import java.sql.Date;

/**
 * Created by employee on 10/21/15.
 */
public class FlightOptions {
    public Date date;
    public int numberOfTicket;
    public City city;
    public FlightOptions(Date date, int numberOfTicket, City city){
        this.date = date;
        this.numberOfTicket = numberOfTicket;
        this.city = city;
    }

//


    @Override
    public String toString() {
        return String.format("%s %s", city.getName(), date);
    }
}
