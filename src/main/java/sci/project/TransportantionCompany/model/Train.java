package sci.project.TransportantionCompany.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    //asta practic e numele trenului-personal,accelerat,etc
    @Column(name = "type", nullable = false)
    private String type;

    //un tren poate face mai multe rute (in zile diferite,ore,etc)
    //un tren are o lista de rute pe care le poate face
    @OneToMany
            (
                    mappedBy = "train",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<TrainRoute> routes = new ArrayList<>();

    //one train has more wagons=>one to many
    @OneToMany
            (
                    mappedBy = "train",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<Wagon> wagons = new ArrayList<>();

}
