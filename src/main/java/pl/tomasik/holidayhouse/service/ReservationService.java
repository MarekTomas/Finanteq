package pl.tomasik.holidayhouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tomasik.holidayhouse.model.Person;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.model.Room;
import pl.tomasik.holidayhouse.model.dto.RoomReservationDto;
import pl.tomasik.holidayhouse.repository.PersonRepository;
import pl.tomasik.holidayhouse.repository.ReservationRepository;
import pl.tomasik.holidayhouse.repository.RoomRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final RoomRepository roomRepository;
    private final PersonRepository personRepository;
    private final ReservationRepository reservationRepository;


    public Reservation createReservation(RoomReservationDto roomReservationDto) {

        var reservation = new Reservation();
        reservation.setStartReservationDate(roomReservationDto.getStartReservationDate());
        reservation.setEndReservationDate(roomReservationDto.getEndReservationDate());
        reservation.setPerson(getPerson(roomReservationDto.getPersonId()));
        reservation.setRoom(getRoom(roomReservationDto.getRoomId()));
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
