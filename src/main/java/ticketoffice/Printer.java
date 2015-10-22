package ticketoffice;

/**
 * Created by employee on 10/22/15.
 */
public interface Printer {
    void printHelloMessage();
    void printInputDateMessage();
    void printInputTicketMessage();
    void printInputCityMessage();
    void printSorryMessage();
    void printTicket(Ticket ticket);
    void printFlightInfo(FlightImpl flightImpl);
}
