package core.entity;

import javax.persistence.*;
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

    @Column(name = "name")
    private String name;

//    @ManyToOne
//    @JoinTable
//            (
//                    name="idCity",
//                    joinColumns={ @JoinColumn(name="idCity", referencedColumnName="idCity") },
//                    inverseJoinColumns={ @JoinColumn(name="id", referencedColumnName="id", unique=true) }
//            )

//    @Column(name = "idCity")
//    private int idCity;
    @ManyToOne
    @JoinColumn(name = "idCity")
    private City city;

    @Column(name = "dateTime")
    private Date dateTime;

    @Column(name = "numberOfPlace")
    private int numberOfPlace;

    @Column(name = "numberOfReservedPlace")
    private int numberOfReservedPlace;

    Flight(){}
    public Flight( Date dateTime, String name,   int numberOfPlace){
        this.name = name;
        this.dateTime = dateTime;
        this.numberOfPlace = numberOfPlace;

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
//        "select count(t.id)"+
//        "from Ticket t, Flight f "+
//        "where (t.id = f.id)and(t.reserved = true)"
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
