package sci.project.TransportantionCompany.model;

import javax.persistence.*;

@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private String id;
    @Column(name= "numberOfSeats",nullable=false)
    private int numberOfSeats;



}
