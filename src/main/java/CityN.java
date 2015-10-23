import javax.persistence.*;

/**
 * Created by employee on 10/23/15.
 */
@Entity
public class CityN {
    public void setId() {
        this.id = 1;
    }

    public void setName() {
        this.name = "SS";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city", length = 100, nullable = false)
    private String name;
}
