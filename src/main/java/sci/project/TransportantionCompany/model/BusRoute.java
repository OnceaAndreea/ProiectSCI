package sci.project.TransportantionCompany.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "busRoute")
public class BusRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "departure", nullable = false)
    private String departure;

    @Column(name= "departure_station", nullable=false)
    private String departureStation;

    @Column(name = "arrival", nullable = false)
    private String arrival;

    @Column(name = "arrival_station", nullable = false)
    private String arrivalStation;

    @Column(name = "departureTime", nullable = false)
    private String departureTime;

    @Column(name = "departureDate", nullable = false)
    private String departureDate;

    @Column(name = "arrivalTime", nullable = false)
    private String arrivalTime;

    @Column(name = "distance", nullable = false)
    private int distance;

    @Column(name = "price", nullable = false)
    private double price;

    // mai multe rute pot fi facute de acelasi bus(in momente de timp diferite)
    //fiecare busRoute are toate informatiile despre bus-ul care o face
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
}

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }
}
