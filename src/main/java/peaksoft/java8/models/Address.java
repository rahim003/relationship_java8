package peaksoft.java8.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author krasa kurbanov
 * @created 25/01/2023 - 12:20
 **/
@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String zip;
    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
