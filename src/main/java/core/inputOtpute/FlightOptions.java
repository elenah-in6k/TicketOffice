package core.inputOtpute;

import core.entity.City;
import core.entity.Flight;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

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
