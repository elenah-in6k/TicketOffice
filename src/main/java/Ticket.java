import java.time.LocalDate;

/**
 * Created by employee on 10/20/15.
 */
public class Ticket {

    boolean reserved = false;
    int seatingPosition;

    Ticket(int seatingPosition){
        this.seatingPosition = seatingPosition;
    }
    boolean isReserved(){
        return reserved;
    }
    void Booking(){
        reserved = true;
    }

}
