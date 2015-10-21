import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алена on 22.10.2015.
 */
public class AllFlights {
    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    List<Flight> flights = new ArrayList<Flight>();
    public void createFlightsList() {
        addFlight(new Flight(new City("Kyiv"),
                dateTime("27.11.2015 13:15"), 20));
        addFlight(new Flight(new City("Lviv"),
                dateTime("26.11.2015 15:15"), 40));
        addFlight(new Flight(new City("Odesa"),
                dateTime("15.11.2015 07:15"), 30));
        addFlight(new Flight(new City("Lviv"),
                dateTime("27.11.2015 12:15"), 40));

    }

    private LocalDateTime dateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DATETIME_FORMAT);
    }

    public Flight searchFlight(FlightOptions flightOptions) {
        if (flights.size() == 0) return null;
        for (Flight flight : flights) {
            if (flightOptions.test(flight))
                return flight;
        }
        return null;
    }


    public void addFlight(Flight flight) {
        flights.add(flight);
    }
}
