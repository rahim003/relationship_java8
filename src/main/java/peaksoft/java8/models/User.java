package peaksoft.java8.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import peaksoft.java8.enums.Gender;

import java.util.Date;

/**
 * @author krasa kurbanov
 * @created 25/01/2023 - 12:20
 **/
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    //getters and setters
}




