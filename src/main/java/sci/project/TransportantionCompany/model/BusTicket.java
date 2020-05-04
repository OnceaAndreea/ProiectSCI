package sci.project.TransportantionCompany.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bus_ticket")
public class BusTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "departure", nullable = false)
    private String departure;

    @Column(name = "departure_station", nullable = false)
    private String departureStation;

    @Column(name = "arrival", nullable = false)
    private String arrival;

    @Column(name = "arrival_station", nullable = false)
    private String arrivalStation;

    @Column(name = "departureDate", nullable = false)
    private String departureDate;

    @Column(name = "departureTime", nullable = false)
    private String departureTime;

    @Column(name = "arrivalTime", nullable = false)
    private String arrivalTime;

    @Column(name = "distance", nullable = false)
    private int distance;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "busTicket", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private TicketDetails details;

    public BusTicket(String departure, String departureStation, String arrival, String arrivalStation, String departureDate, String departureTime, String arrivalTime, int distance, double price, User user) {
        this.departure = departure;
        this.departureStation = departureStation;
        this.arrival = arrival;
        this.arrivalStation = arrivalStation;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.distance = distance;
        this.price = price;
        this.user = user;
    }

    public BusTicket() {
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TicketDetails getDetails() {
        return details;
    }

    public void setDetails(TicketDetails details) {
        this.details = details;
    }
}
