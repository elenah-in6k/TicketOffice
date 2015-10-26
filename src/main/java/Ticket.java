import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * Created by Алена on 25.10.2015.
 */
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTicket;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "idFlight")
    private int idFlight;

    @Column(name = "numberOfPlace")
    private int numberOfPlace;

    @Column(name = "reserved")
    private boolean reserved;

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public void setNumberOfPlace(int numberOfPlace) {
        this.numberOfPlace = numberOfPlace;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getIdTicket() {

        return idTicket;
    }

    public String getName() {
        return name;
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
