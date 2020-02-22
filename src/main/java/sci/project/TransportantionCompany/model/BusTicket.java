package sci.project.TransportantionCompany.model;

import javax.persistence.*;

@Entity
@Table(name = "trainRoute")
public class BusTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
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

    //un bilet corespunde unui anumit user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private TranspUser transpUser;

}
