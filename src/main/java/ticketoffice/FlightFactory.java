package ticketoffice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алена on 22.10.2015.
 */
public class FlightFactory {
    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    List<FlightImpl> flightImpls = new ArrayList<FlightImpl>();
    public void createFlightsList() {
        addFlight(new FlightImpl(new City("Kyiv"),
                dateTime("27.11.2015 13:15"), 20));
        addFlight(new FlightImpl(new City("Lviv"),
                dateTime("26.11.2015 15:15"), 40));
        addFlight(new FlightImpl(new City("Odesa"),
                dateTime("15.11.2015 07:15"), 30));
        addFlight(new FlightImpl(new City("Lviv"),
                dateTime("27.11.2015 12:15"), 40));

    }

    private LocalDateTime dateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DATETIME_FORMAT);
    }


    public void addFlight(FlightImpl flightImpl) {
        flightImpls.add(flightImpl);
    }
}
