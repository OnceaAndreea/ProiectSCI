package sci.project.TransportantionCompany.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainRoute")
public class TrainRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
//    @Column(name = "trainId",nullable = false)
//    private int trainId;
    @Column(name = "departure",nullable = false)
    private String departure;
    @Column(name = "arrival",nullable = false)
    private String arrival;
    @Column(name = "departureTime",nullable = false)
    private String departureTime;
    @Column(name = "arrivalTime",nullable = false)
    private String arrivalTime;
    @Column(name = "distance",nullable = false)
    private int distance;
    @Column(name = "priceFirstClass",nullable = false)
    private double priceFirstClass;
    @Column(name = "priceSecondClass",nullable = false)
    private double priceSecondClass;
    @Column(name = "priceSleepingWagon",nullable = false)
    private double priceSleepingWagon;

    @OneToMany
            (
                    mappedBy = "TrainRoute",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<Train> trains = new ArrayList<>(); //o trainroute poate fi facuta de mai multe trenuri
    //avem o lista de trenuri care pot efectua ruta respectiva
}
