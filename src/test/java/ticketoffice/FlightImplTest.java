package ticketoffice;

import org.junit.Test;
import ticketoffice.City;
import ticketoffice.FlightImpl;
import ticketoffice.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/21/15.
 */
public class FlightImplTest {
    City city = new City("Lviv");
    int numberOfPlaces =  4;
    LocalDate date = LocalDate.parse("15/11/2015",
            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    LocalTime time = LocalTime.parse("17:15");
    FlightImpl flightImpl = new FlightImpl(city, numberOfPlaces, date, time);
    @Test
    public void testCreateFlight(){

        FlightImpl flightImpl = new FlightImpl(city, numberOfPlaces, date, time);
        assertThat(flightImpl.city, is(city));
        assertThat(flightImpl.numberOfPlaces, is(numberOfPlaces));
        assertThat(flightImpl.date, is(date));
        assertThat(flightImpl.time, is(time));
    }

    @Test
    public void testIsNearDate(){
        LocalDate nearDate = LocalDate.parse("20/11/2015",
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertThat(flightImpl.isNearDate(nearDate), is(true));
    }

    @Test
    public void testGetNumberOfReservedPlaces(){
        assertThat(flightImpl.getNumberOfReservedPlaces(), is(0));

    }

    @Test
    public void testBuyTicket(){
        Ticket ticket = flightImpl.buyTicket();
         assertThat(ticket.isReserved(), is(true));
        assertThat(flightImpl.getNumberOfReservedPlaces(), is(1));
    }

    @Test
    public void testGetnumberOfEmptyPlaces(){
        assertThat(flightImpl.getNumberOfEmptyPlaces(), is(4));
        flightImpl.buyTicket();
        assertThat(flightImpl.getNumberOfEmptyPlaces(), is(3));
    }

}
