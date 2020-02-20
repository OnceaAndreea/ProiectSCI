package sci.project.TransportantionCompany.model;


import javax.persistence.*;

@Entity
@Table(name="wagon")
public class Wagon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "trainId",nullable = false)
    private int trainId;
    @Column(name="type",nullable=false)
    private String type;
    @Column(name="numberOfSeats",nullable=false)
    private int numberOfSeats;
}
