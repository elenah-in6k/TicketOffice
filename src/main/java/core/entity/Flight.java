package core.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by employee on 10/23/15.
 */
@Entity
@Table(name="Flight")
public class Flight implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFlight;

    @Column(name = "name")
    private String name;

    @Column(name = "idCity")
    private int idCity;

    @Column(name = "dateTime")
    private Date dateTime;

    @Column(name = "numberOfPlace")
    private int numberOfPlace;

    @Column(name = "numberOfReservedPlace")
    private int numberOfReservedPlace;
    Flight(){}
    Flight(String name, int idCity, Date dateTime, int numberOfPlace){
        this.name = name;
        this.idCity = idCity;
        this.dateTime = dateTime;
        this.numberOfPlace = numberOfPlace;
    }
    public int getIdCity() {
        return idCity;
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
//        "where (t.idFlight = f.id)and(t.reserved = true)"
    }

    public void setId() {
        this.idFlight = 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdFlight() {
        return idFlight;
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

}
