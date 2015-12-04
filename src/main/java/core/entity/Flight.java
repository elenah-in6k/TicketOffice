package core.entity;



import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by employee on 10/23/15.
 */
@Entity
@Table(name="Flight")
public class Flight{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "idCity")
    private City city;

    @Column(name = "dateTime")
    private Date dateTime;

    @Min(0)
    @Column(name = "numberOfPlace")
    private int numberOfPlace;
    @Min(0)
    @Column(name = "numberOfReservedPlace")
    private int numberOfReservedPlace;

    Flight(){}
    public Flight( Date dateTime, String name,   int numberOfPlace, City city){
        this.name = name;
        this.dateTime = dateTime;
        this.numberOfPlace = numberOfPlace;
        this.city = city;
        this.numberOfReservedPlace = 0;
    }
    public City getCity() {
        return city;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    public int getNumberOfReservedPlace() {
        return numberOfReservedPlace;
    }

    public void setId() {
        this.id = 1;
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

    public boolean isNearDate(LocalDate nearDate){
        return false;
        // (dateTime.isAfter(LocalDate.now())) &
                //(dateTime.toLocalDate().isBefore(nearDate));
    }
    public int getNumberOfEmptyPlaces(){
        return numberOfPlace - getNumberOfReservedPlace();
    }

    public Flight getFlight (Object o){

        return null;
    }
}
