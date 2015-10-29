package core.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by employee on 10/23/15.
 */
@Entity
@Table(name="City")
public class City {
    @Id

    @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;


    public City(){}

    public City(String name){
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
