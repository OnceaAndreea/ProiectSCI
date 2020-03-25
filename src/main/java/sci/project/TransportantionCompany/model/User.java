package sci.project.TransportantionCompany.model;

import sci.project.TransportantionCompany.model.enums.TranspUserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    //un user poate avea mai multe roluri si un acelasi rol il pot avea mai multi useri
    //se rezolva relatia manytomany prin adaugarea unei tabele intermediare users_roles

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    //un user poate avea mai multe busTickets
    @OneToMany
            (
                    mappedBy = "user",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<BusTicket> busTickets = new ArrayList<>();

    //un user poate avea mai multe trainTickets
    @OneToMany
            (
                    mappedBy = "user",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<TrainTicket> trainTickets = new ArrayList<>();

    public User() {
    }

    public User(String email, String password, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
