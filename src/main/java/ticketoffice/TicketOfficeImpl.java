package ticketoffice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/20/15.
 */
public class TicketOfficeImpl implements TicketOffice {

    private List<FlightImpl> flights = new ArrayList<FlightImpl>();

    public FlightImpl searchFlight(FlightOptions flightOptions) {
        if (flights.size() == 0) return null;
        for (FlightImpl flightImpl : flights) {
            if (flightOptions.test(flightImpl))
                return flightImpl;
        }
        return null;
    }

    public void addFlight(FlightImpl flightImpl) {
        flights.add(flightImpl);
    }
}
