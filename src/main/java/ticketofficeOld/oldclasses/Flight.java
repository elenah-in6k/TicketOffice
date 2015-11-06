package ticketofficeOld.oldclasses;

import java.time.LocalDate;

/**
 * Created by employee on 10/22/15.
 */
public interface Flight {
    boolean isNearDate(LocalDate nearDate);
    int getNumberOfEmptyPlaces();
    int getNumberOfReservedPlaces();
    Ticket buyTicket();

}
