package sci.project.TransportantionCompany.model;

import sci.project.TransportantionCompany.model.enums.TranspUserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class TranspUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "role",nullable = false)
    private TranspUserRole role;

    //un user poate avea mai multe busTickets
    @OneToMany
            (
                    mappedBy = "transpUser",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<BusTicket> busTickets = new ArrayList<>();

    //un user poate avea mai multe trainTickets
    @OneToMany
            (
                    mappedBy = "transpUser",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<TrainTicket> trainTickets = new ArrayList<>();









}
