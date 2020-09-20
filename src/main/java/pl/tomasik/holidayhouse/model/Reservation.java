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
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "RESERVATION")
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROOM_NUMBER")
    @NonNull
    private int roomNumber;

    @Column(name = "START_RESREVATION_DATE")
    private LocalDate startReservationDate;

    @Column(name = "END_RESREVATION_DATE")
    private LocalDate endReservationDate;

    @Column(name = "IS_RESERVED")
    private boolean isReserved = false;

}
