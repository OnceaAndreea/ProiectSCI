package sci.project.TransportantionCompany.model;


import javax.persistence.*;

@Entity
@Table(name = "wagon")
public class Wagon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainId", nullable = false)
    private Train train;

    @Column(name = "type", nullable = false)//clasa 1,clasa2,cuseta
    private String type;

    @Column(name = "number_of_available_seats", nullable = false)
    private int numberOfAvailableSeats;
}
