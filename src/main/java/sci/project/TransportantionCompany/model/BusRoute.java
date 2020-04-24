package sci.project.TransportantionCompany.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "busRoute")
public class BusRoute implements Comparable<BusRoute> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @NotEmpty(message = "Camp necompletat! Introduceti orasul de plecare")
    @Column(name = "departure", nullable = false)
    private String departure;

    @Column(name = "departure_station", nullable = false)
    private String departureStation;

    @NotEmpty(message = "Camp necompletat! Introduceti orasul de sosire")
    @Column(name = "arrival", nullable = false)
    private String arrival;

    @Column(name = "arrival_station", nullable = false)
    private String arrivalStation;

    @Column(name = "departureTime", nullable = false)
    private String departureTime;

    @NotEmpty(message = "Camp necompletat! Introduceti data cursei")
    @Column(name = "departureDate", nullable = false)
    private String departureDate;

    @Column(name = "arrivalTime", nullable = false)
    private String arrivalTime;

    @Column(name = "distance", nullable = false)
    private int distance;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "available_tickets", nullable = false)
    private int numberOfAvailableTickets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", columnDefinition="VARCHAR(64)", nullable = false)
    private Bus bus;

    public BusRoute() {
    }

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

    public int getNumberOfAvailableTickets() {
        return numberOfAvailableTickets;
    }

    public void setNumberOfAvailableTickets(int numberOfAvailableTickets) {
        this.numberOfAvailableTickets = numberOfAvailableTickets;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void updateAvailableTickets(int quantity){
        this.numberOfAvailableTickets=this.numberOfAvailableTickets-quantity;
    }

    @Override
    public int compareTo(BusRoute busRoute) {
        return this.departureTime.compareTo(busRoute.departureTime);
    }
}