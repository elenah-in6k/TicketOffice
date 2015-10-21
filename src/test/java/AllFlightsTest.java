import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by employee on 10/21/15.
 */
public class AllFlightsTest {

    public static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private AllFlights allFlights;
    private City lviv = new City("Lviv");

    @Before
    public void setUp() {
        allFlights = new AllFlights();
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
    public void testNoFlights() throws Exception {
        FlightOptions options = flightOptions("Lviv", "30.11.2015");

        Flight flight = allFlights.searchFlight(options);

        assertThat(flight, nullValue());
    }

    @Test
    public void testFlightThatSatisfyAllCriteria() throws Exception {

        Flight flight1 = new Flight(lviv, dateTime("18.12.2015 12:15"), 10);
        allFlights.addFlight(flight1);
        Flight flight2 = new Flight(new City("Kyiv"), dateTime("27.11.2015 12:15"), 10);
        allFlights.addFlight(flight2);
        Flight flight3 = new Flight(new City("Odesa"), dateTime("15.11.2015 12:15"), 10);
        allFlights.addFlight(flight2);
        FlightOptions options = flightOptions("Lviv", "30.11.2015");
        Flight flight = new Flight(lviv, dateTime("27.11.2015 12:15"), 10);
        allFlights.addFlight(flight);
        Flight foundFlight = allFlights.searchFlight(options);

        assertThat(foundFlight, is(flight));
    }

    @Test
    public void testFlightThatNotSatisfyCityCriteria() throws Exception {
        Flight flight = new Flight(lviv, dateTime("29.11.2015 12:15"), 10);
        allFlights.addFlight(flight);
        FlightOptions options = flightOptions("Kiev", "30.11.2015");

        Flight foundFlight = allFlights.searchFlight(options);

        assertThat(foundFlight, nullValue());
    }
    @Test
    public void testFlightThatNotSatisfyAllCriterias() throws Exception {
        Flight flight = new Flight(lviv, dateTime("29.11.2015 12:15"), 10);
        allFlights.addFlight(flight);
        FlightOptions options = flightOptions("Kiev", "15.11.2015");

        Flight foundFlight = allFlights.searchFlight(options);

        assertThat(foundFlight, nullValue());
    }
}
