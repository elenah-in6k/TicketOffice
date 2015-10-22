package ticketoffice;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/22/15.
 */
public class TicketOfficeControllerTest implements Printer, InputOptions, TicketOffice {

    private List<String> actions = new ArrayList<String>();
    private TicketOfficeController controller;

    @Before
    public void setUp() throws Exception {
        controller = new TicketOfficeController(this, this, this);
    }

    @Test
    public void testTakesSearchOptionsAndPrintFoundFlight() throws Exception {

//        when
        controller.openTicketOffice();

//        then
        assertThat(actions, is(Arrays.asList(
                "read options",
                "search{Lviv 2015-11-30}",
                "print{Lviv 2015-11-27}"
        )));
    }

    public void printSorryMessage() {
    }

    public void printFlightInfo(FlightImpl flightImpl) {
        logAction("print", flightImpl.toString());
    }

    private void logAction(String action, Object arg) {
        actions.add(String.format(action + "{%s}", arg));
    }

    public FlightOptions readSearchOptions() {
        actions.add("read options");
        return new FlightOptions(LocalDate.of(2015, 11, 30), 10, new City("Lviv"));
    }

    public void printHelloMessage() {

    }

    public void printInputDateMessage() {

    }

    public void printInputTicketMessage() {

    }

    public void printInputCityMessage() {

    }

    public void printTicket(Ticket ticket) {

    }

    public FlightImpl searchFlight(FlightOptions flightOptions) {
        logAction("search", flightOptions);
        return new FlightImpl(new City("Lviv"), LocalDateTime.of(2015, 11, 27, 12, 15), 10);
    }

    public void addFlight(FlightImpl flightImpl) {
  
    }
}
