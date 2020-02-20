package sci.project.TransportantionCompany.model;

import javax.persistence.*;

@Entity
@Table(name = "trainRoute")
public class TrainRoute {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "trainId",nullable = false)
    private int trainId;
    @Column(name = "departure",nullable = false)
    private String departure;

    private String arrival;
    private String departureTime;
    private String arrivalTime;
    private int distance;
    private double priceFirstClass;
    private double priceSecondclass;
    private double priceSleepingWagon;
}
