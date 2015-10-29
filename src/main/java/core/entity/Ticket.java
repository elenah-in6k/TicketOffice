package core.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by Алена on 25.10.2015.
 */
@Entity
public class Ticket{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTicket;

    @Column(name = "idFlight")
    private int idFlight;

    @Column(name = "numberOfPlace")
    private int numberOfPlace;

    @Column(name = "reserved")
    private boolean reserved = false;
    Ticket(){}

    Ticket(int idFlight,int numberOfPlace){
        this.idFlight = idFlight;
        this.numberOfPlace = numberOfPlace;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public void setNumberOfPlace(int numberOfPlace) {
        this.numberOfPlace = numberOfPlace;
    }

    public void setReserved() {
        this.reserved = true;
    }

    public int getIdTicket() {

        return idTicket;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    public boolean isReserved() {
        return reserved;
    }
}
