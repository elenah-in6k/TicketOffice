import javax.persistence.*;

/**
 * Created by employee on 10/23/15.
 */
@Entity
public class City {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCity;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
}
