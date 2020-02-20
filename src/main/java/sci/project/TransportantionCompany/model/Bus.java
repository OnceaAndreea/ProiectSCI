package sci.project.TransportantionCompany.model;

import javax.persistence.*;

@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name= "numberOfSeats",nullable=false)
    private int numberOfSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routeId", nullable = false) //cheia straina din busRoute
    private BusRoute busRoute;

}
