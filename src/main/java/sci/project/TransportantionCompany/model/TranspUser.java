package sci.project.TransportantionCompany.model;

import enums.TranspUserRole;

import javax.persistence.*;

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





}
