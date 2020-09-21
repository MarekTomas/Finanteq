package pl.tomasik.holidayhouse.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.Person;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.model.Room;
import pl.tomasik.holidayhouse.repository.PersonRepository;
import pl.tomasik.holidayhouse.repository.ReservationRepository;
import pl.tomasik.holidayhouse.repository.RoomRepository;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ReservationFactory {

    private final RoomRepository roomRepository;
    private final PersonRepository personRepository;
    private final ReservationRepository reservationRepository;


    public Reservation createReservation(Long roomId, LocalDate startReservationDate, LocalDate endReservationDate, Long personId) {

        var reservation = new Reservation();
        reservation.setStartReservationDate(startReservationDate);
        reservation.setEndReservationDate(endReservationDate);
        reservation.setPerson(getPerson(personId));
        reservation.setRoom(getRoom(roomId));
        return reservationRepository.save(reservation);
    }

    private Person getPerson(Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("No person found for personId:" + personId));
    }

    private Room getRoom(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("No room found for roomId:" + roomId));
    }
}
