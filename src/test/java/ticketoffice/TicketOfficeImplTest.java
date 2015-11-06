//package ticketoffice;
//
//import core.inputOutput.FlightOptions;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import ticketofficeOld.service.TicketOffice;
//import ticketofficeOld.oldclasses.City;
//import ticketofficeOld.oldclasses.Flight;
//import ticketofficeOld.oldclasses.FlightImpl;
//import ticketofficeOld.oldclasses.TicketOfficeImpl;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.CoreMatchers.*;
//
///**
// * Created by employee on 10/21/15.
// */
//@Ignore
//public class TicketOfficeImplTest {
//
//    public static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
//    private service.TicketOffice ticketOffice;
//    private City lviv = new City("Lviv");
//    private City kyiv = new City("Kyiv");
//    private FlightOptions options;
//
//    @Before
//    public void setUp() {
//        ticketOffice = new TicketOfficeImpl();
//        options = flightOptions("Lviv", "30.11.2015");
//    }
//
//    private FlightOptions flightOptions(String city, String date, int tickets) {
//        return null;//new FlightOptions(date(date), tickets, new City(city));
//    }
//
//    private LocalDate date(String date) {
//        return LocalDate.parse(date,
//                FORMAT);
//    }
//
//    private LocalDateTime dateTime(String dateTime) {
//        return LocalDateTime.parse(dateTime, DATETIME_FORMAT);
//    }
//
//    private FlightOptions flightOptions(String city, String date) {
//        return flightOptions(city, date, 1);
//    }
//
//    private FlightImpl addFlight(City city, String dateTime) {
//        FlightImpl flight = new FlightImpl(city, dateTime(dateTime), 10);
//        ticketOffice.addFlight(flight);
//        return flight;
//    }
//
//    private void assertFlightNotFound() {
//        Flight flightImpl = ticketOffice.searchFlight(options);
//        assertThat(flightImpl, nullValue());
//    }
//
//    @Test
//    public void testFlightThatSatisfyAllCriteria() throws Exception {
//        addFlight(lviv, "18.12.2015 12:15");
//        addFlight(kyiv, "27.11.2015 12:15");
//        FlightImpl desiredFlight = addFlight(lviv, "27.11.2015 12:15");
//
//        FlightImpl foundFlightImpl = ticketOffice.searchFlight(options);
//
//        assertThat(foundFlightImpl, is(desiredFlight));
//    }
//
//    @Test
//    public void testNoFlights() throws Exception {
//        assertFlightNotFound();
//    }
//
//    @Test
//    public void testFlightThatNotSatisfyCityCriteria() throws Exception {
//        addFlight(kyiv, "27.11.2015 12:15");
//        assertFlightNotFound();
//    }
//
//    @Test
//    public void testFlightThatNotSatisfyAllCriterias() throws Exception {
//        addFlight(kyiv, "18.12.2015 12:15");
//        assertFlightNotFound();
//    }
//}
