import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/21/15.
 */
public class FlightTest {
    City city = new City("Lviv");
    int numberOfPlaces =  4;
    LocalDate date = LocalDate.parse("15/11/2015",
            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    LocalTime time = LocalTime.parse("17:15");
    Flight flight = new Flight (city, numberOfPlaces, date, time);
    @Test
    public void testCreateFlight(){

        Flight flight = new Flight (city, numberOfPlaces, date, time);
        assertThat(flight.city, is(city));
        assertThat(flight.numberOfPlaces, is(numberOfPlaces));
        assertThat(flight.date, is(date));
        assertThat(flight.time, is(time));
    }

    @Test
    public void testIsNearDate(){
        LocalDate nearDate = LocalDate.parse("20/11/2015",
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertThat(flight.isNearDate(nearDate), is(true));
    }

    @Test
    public void testGetNumberOfReservedPlaces(){
        assertThat(flight.getNumberOfReservedPlaces(), is(0));

    }

    @Test
    public void testBuyTicket(){
        Ticket ticket = flight.buyTicket();
         assertThat(ticket.isReserved(), is(true));
        assertThat(flight.getNumberOfReservedPlaces(), is(1));
    }

    @Test
    public void testGetnumberOfEmptyPlaces(){
        assertThat(flight.getNumberOfEmptyPlaces(), is(4));
        flight.buyTicket();
        assertThat(flight.getNumberOfEmptyPlaces(), is(3));
    }

}
