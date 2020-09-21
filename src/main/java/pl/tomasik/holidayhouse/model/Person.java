package pl.tomasik.holidayhouse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "PERSON")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    @NonNull
    private String name;

    @Column(name = "SURNAME")
    @NonNull
    private String surname;

    @Column(name = "EMAIL")
    @NonNull
    private String email;

    @Column(name = "PASSWORD")
    @NonNull
    private String password;

    @Column(name = "ROLE")
    @NonNull
    private String role;

    @OneToMany(mappedBy = "person")
    private List<Reservation> reservationEntities;
}
