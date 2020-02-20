package sci.project.TransportantionCompany.model;


import javax.persistence.*;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private String id;
    @Column(name = "wagonId",nullable = false)
    private int wagonId;
    @Column(name = "type",nullable = false)
    private String type;



    }
