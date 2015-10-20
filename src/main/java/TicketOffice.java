/**
 * Created by employee on 10/20/15.
 */
public class TicketOffice {

    public void main(String[] s){

    }

    public void buyTicket(Flight flight){
        if(flight.getNumberOfEmptyPlaces() > 0){
        for(Ticket ticket : flight.flight){
            if(!ticket.isReserved()){
                ticket.Booking();
                break;}
            }
        }
    }

}
