import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by employee on 10/23/15.
 */
@Entity
public class City implements Serializable {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCity;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    public void setId() {
        this.idCity = 1;
    }

    public void setName() {
        this.name = "SS";
    }

    public int getIdCity() {
        return idCity;
    }

    public String getName() {
        return name;
    }
}
