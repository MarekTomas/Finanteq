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
@Table(name = "ROOM")
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROOM_NUMBER")
    @NonNull
    private String roomNumber;

    @Column(name = "NUMBER_OF_BEDS")
    @NonNull
    private String numberOfBeds;

    @OneToMany(mappedBy = "room")
    private List<Reservation> conectedReservation;
}
