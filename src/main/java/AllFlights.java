/**
 * Created by employee on 10/22/15.
 */
public interface AllFlights {
    void createFlightsList();
    FlightImpl searchFlight(FlightOptions flightOptions);
    void addFlight(FlightImpl flightImpl);
}
