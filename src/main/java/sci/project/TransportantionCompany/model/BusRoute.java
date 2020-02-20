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
//    @Column(name = "busId", nullable = false)
//    private int busId;
    @Column(name = "departure", nullable = false)
    private String departure;
    @Column(name = "arrival", nullable = false)
    private String arrival;
    @Column(name = "departureTime", nullable = false)
    private String departureTime;
    @Column(name = "arrivalTime", nullable = false)
    private String arrivalTime;
    @Column(name = "distance", nullable = false)
    private int distance;
    @Column(name = "price", nullable = false)
    private double price;

    @OneToMany
            (
                    mappedBy = "BusRoute",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<Bus> buses = new ArrayList<>();// o ruta poate fi facuta de mai multe bus-uri(in zile diferite,ore,etc)

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
}
