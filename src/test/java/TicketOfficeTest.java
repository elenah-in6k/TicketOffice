import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by employee on 10/21/15.
 */
public class TicketOfficeTest {

    public static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private TicketOffice ticketOffice;
    private City lviv = new City("Lviv");

    @Before
    public void setUp() {
        ticketOffice = new TicketOffice();
    }

    private FlightOptions flightOptions(String city, String date, int tickets) {
        return new FlightOptions(date(date), tickets, new City(city));
    }

    private LocalDate date(String date) {
        return LocalDate.parse(date,
                FORMAT);
    }

    private LocalDateTime dateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DATETIME_FORMAT);
    }

    private FlightOptions flightOptions(String city, String date) {
        return flightOptions(city, date, 1);
    }

    @Test
    public void testSearchFlight(){
        ticketOffice.flights.add(new Flight(new City("Kyiv"), 20,
                LocalDate.parse("27/11/2015",
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse("12:15")));
        ticketOffice.flights.add(new Flight(new City("Odesa"), 30,
                LocalDate.parse("15/11/2015",
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse("17:15")));
        ticketOffice.flights.add(new Flight(new City("Lviv"), 40,
                LocalDate.parse("27/11/2015",
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse("12:15")));
    }

    @Test
    public void testNoFlights() throws Exception {
        FlightOptions options = flightOptions("Lviv", "30.11.2015");

        Flight flight = ticketOffice.searchFlight(options);

        assertThat(flight, nullValue());
    }

    @Test
    public void testFlightThatSatisfyAllCriteria() throws Exception {
        Flight flight = new Flight(lviv, dateTime("29.11.2015 12:15"), 10);
        ticketOffice.addFlight(flight);
        FlightOptions options = flightOptions("Lviv", "30.11.2015");

        Flight foundFlight = ticketOffice.searchFlight(options);

        assertThat(foundFlight, is(flight));
    }

    @Test
    public void testFlightThatNotSatisfyCityCriteria() throws Exception {
        Flight flight = new Flight(lviv, dateTime("29.11.2015 12:15"), 10);
        ticketOffice.addFlight(flight);
        FlightOptions options = flightOptions("Kiev", "30.11.2015");

        Flight foundFlight = ticketOffice.searchFlight(options);

        assertThat(foundFlight, nullValue());
    }
}
