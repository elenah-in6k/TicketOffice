import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by employee on 10/22/15.
 */
public interface Flight {
    boolean isNearDate(LocalDate nearDate);
    int getNumberOfEmptyPlaces();
    int getNumberOfReservedPlaces();
    Ticket buyTicket();

}
