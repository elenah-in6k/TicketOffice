import java.time.LocalDate;

/**
 * Created by employee on 10/21/15.
 */
public class FlightOptions {
    LocalDate date;
    int numberOfTicket;
    City city;
    FlightOptions(LocalDate date, int numberOfTicket, City city){
        this.date = date;
        this.numberOfTicket = numberOfTicket;
        this.city = city;
    }

    public boolean test(Flight flight) {
        return flight.city.equals(city);

    }
}
