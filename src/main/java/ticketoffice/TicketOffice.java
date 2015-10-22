package ticketoffice;

/**
 * Created by employee on 10/22/15.
 */
public interface TicketOffice {
    FlightImpl searchFlight(FlightOptions flightOptions);
    void addFlight(FlightImpl flightImpl);
}
