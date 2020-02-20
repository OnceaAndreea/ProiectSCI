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
    private String id;
    @Column(name = "type", nullable = false)
    private String type;

    //one train has more wagons=>one to many
    @OneToMany
            (
                    mappedBy = "train",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<Wagon> wagons = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainId", nullable = false)//cheie straina
    private TrainRoute trainRoute;
}
