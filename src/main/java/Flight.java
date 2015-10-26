import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by employee on 10/23/15.
 */
@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFlight;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "idCity")
    private int idCity;

    @Column(name = "dataTime")
    private LocalDateTime dateTime;

    @Column(name = "numberOfPlace")
    private int numberOfPlace;

    @Column(name = "numberOfReservedPlace")
    private int numberOfReservedPlace;

    public int getIdCity() {
        return idCity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    public int getNumberOfReservedPlace() {
        return numberOfReservedPlace;
    }

    public void setId() {
        this.idFlight = 1;
    }

    public void setName() {
        this.name = "SS";
    }

    public int getIdFlight() {
        return idFlight;
    }

    public String getName() {
        return name;
    }


}
