import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/20/15.
 */
public class Flight {
    City city;
    int numberOfPlaces;
    LocalDate date;
    LocalTime time;
    int numberOfReservedPlaces;
    List<Ticket> flight = new ArrayList<Ticket>(numberOfPlaces);

    Flight(City city, int numberOfPlaces,LocalDate date, LocalTime time){
        this.city = city;
        this.numberOfPlaces = numberOfPlaces;
        this.date = date;
        this.time = time;
        for(int i = 0; i < this.numberOfPlaces; i++){
            flight.add(new Ticket(i));
        }
    }

    public Flight(City city, LocalDateTime dateTime, int places) {
        this(city, places, dateTime.toLocalDate(), dateTime.toLocalTime());
    }

    boolean isNearDate(LocalDate nearDate){
    return (date.isAfter(LocalDate.now())) & (date.isBefore(nearDate));
    }

    int getNumberOfEmptyPlaces(){
        getNumberOfReservedPlaces();
        return numberOfPlaces - numberOfReservedPlaces;
    }

    int getNumberOfReservedPlaces() {
        numberOfReservedPlaces = 0;
        for (Ticket ticket : flight){
            if(ticket.isReserved()){
                numberOfReservedPlaces++;
            }
        }

        return numberOfReservedPlaces;
    }

    public Ticket buyTicket(){
        if(getNumberOfEmptyPlaces() > 0){
            for(Ticket ticket : flight){
                if(!ticket.isReserved()){
                    ticket.Booking();
                    return ticket;
                }
            }
        }
        return null;
    }
}
