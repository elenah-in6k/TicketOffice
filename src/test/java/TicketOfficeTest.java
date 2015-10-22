import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/22/15.
 */
public class TicketOfficeTest implements Printer, InputOptions, AllFlights {

    List<FlightImpl> flights = new ArrayList<FlightImpl>();
    private String outputString;

    public void createFlightsList() {
        flights = Collections.EMPTY_LIST;
    }

    public void printSorryMessage() {
        outputString = "Sorry";
    }

    public void printFlightInfo(FlightImpl flightImpl) {
        outputString ="Info";
    }

    public FlightImpl searchFlight(FlightOptions flightOptions) {
        return null;
    }

    public void addFlight(FlightImpl flightImpl) {

    }

    public FlightOptions setOptions() {
        return null;
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

    @Test
    public void testTicketOffice() {
        createFlightsList();
        FlightOptions flightOptions = setOptions();
        FlightImpl flightImpl = searchFlight(flightOptions);
        if (flightImpl != null) {
            printFlightInfo(flightImpl);
            assertThat(outputString, is("Info"));
        } else {
            printSorryMessage();
            assertThat(outputString, is("Sorry"));
        }
    }


}
