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
    private AllFlights allFlightsImpl;
    private City lviv = new City("Lviv");

    @Before
    public void setUp() {
        allFlightsImpl = new AllFlightsImpl();
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

        Flight flightImpl = allFlightsImpl.searchFlight(options);

        assertThat(flightImpl, nullValue());
    }

    @Test
    public void testFlightThatSatisfyAllCriteria() throws Exception {

        FlightImpl flightImpl1 = new FlightImpl(lviv, dateTime("18.12.2015 12:15"), 10);
        allFlightsImpl.addFlight(flightImpl1);
        FlightImpl flightImpl2 = new FlightImpl(new City("Kyiv"), dateTime("27.11.2015 12:15"), 10);
        allFlightsImpl.addFlight(flightImpl2);
        FlightImpl flightImpl3 = new FlightImpl(new City("Odesa"), dateTime("15.11.2015 12:15"), 10);
        allFlightsImpl.addFlight(flightImpl2);
        FlightOptions options = flightOptions("Lviv", "30.11.2015");
        FlightImpl flightImpl = new FlightImpl(lviv, dateTime("27.11.2015 12:15"), 10);
        allFlightsImpl.addFlight(flightImpl);
        FlightImpl foundFlightImpl = allFlightsImpl.searchFlight(options);

        assertThat(foundFlightImpl, is(flightImpl));
    }

    @Test
    public void testFlightThatNotSatisfyCityCriteria() throws Exception {
        FlightImpl flightImpl = new FlightImpl(lviv, dateTime("29.11.2015 12:15"), 10);
        allFlightsImpl.addFlight(flightImpl);
        FlightOptions options = flightOptions("Kiev", "30.11.2015");

        FlightImpl foundFlightImpl = allFlightsImpl.searchFlight(options);

        assertThat(foundFlightImpl, nullValue());
    }
    @Test
    public void testFlightThatNotSatisfyAllCriterias() throws Exception {
        FlightImpl flightImpl = new FlightImpl(lviv, dateTime("29.11.2015 12:15"), 10);
        allFlightsImpl.addFlight(flightImpl);
        FlightOptions options = flightOptions("Kiev", "15.11.2015");

        FlightImpl foundFlightImpl = allFlightsImpl.searchFlight(options);

        assertThat(foundFlightImpl, nullValue());
    }
}
