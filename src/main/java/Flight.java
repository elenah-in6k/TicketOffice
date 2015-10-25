import javax.persistence.*;

/**
 * Created by employee on 10/23/15.
 */
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFlight;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
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
