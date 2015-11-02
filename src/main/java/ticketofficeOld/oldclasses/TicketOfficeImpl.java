package ticketofficeOld.oldclasses;

import core.inputOutput.FlightOptions;
import ticketofficeOld.FlightFactory;
import ticketofficeOld.TicketOffice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/20/15.
 */
public class TicketOfficeImpl implements TicketOffice {

    private List<FlightImpl> flights = new ArrayList<FlightImpl>();
    public TicketOfficeImpl(){
        FlightFactory flightFactory = new FlightFactory();
        flights = flightFactory.createFlightsList();
    }

//    public FlightImpl searchFlight(FlightOptions flightOptions) {
////        if (flights.size() == 0) return null;
////        for (FlightImpl flightImpl : flights) {
////            if (flightOptions.test(flightImpl))
////                return flightImpl;
////        }
////        return null;
//    }

    @Override
    public FlightImpl searchFlight(FlightOptions flightOptions) {
        return null;
    }

    public void addFlight(FlightImpl flightImpl) {
        flights.add(flightImpl);
    }
}