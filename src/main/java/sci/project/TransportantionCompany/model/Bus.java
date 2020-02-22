package sci.project.TransportantionCompany.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name= "number_of_available_seats",nullable=false)
    private int numberOfAvailableSeats;

    //un bus poate face mai multe rute (in zile diferite,ore,etc)
    //un bus are o lista de rute pe care le poate face
    @OneToMany
            (
                    mappedBy = "bus",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<BusRoute> routes = new ArrayList<>();

}
