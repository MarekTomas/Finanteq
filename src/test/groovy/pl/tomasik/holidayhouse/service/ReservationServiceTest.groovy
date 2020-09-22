package pl.tomasik.holidayhouse.service

import pl.tomasik.holidayhouse.model.Person
import pl.tomasik.holidayhouse.model.Reservation
import pl.tomasik.holidayhouse.model.Room
import pl.tomasik.holidayhouse.model.dto.RoomReservationDto
import pl.tomasik.holidayhouse.repository.PersonRepository
import pl.tomasik.holidayhouse.repository.ReservationRepository
import pl.tomasik.holidayhouse.repository.RoomRepository
import spock.lang.Specification

import java.time.LocalDate

class ReservationServiceTest extends Specification {

    RoomRepository roomRepository = Mock()
    PersonRepository personRepository = Mock()
    ReservationRepository reservationRepository = Mock()
    ReservationService sut = [roomRepository, personRepository, reservationRepository]

    def "should create reservation"() {
        setup:
            Long roomId = 1L
            Long personId = 1L

            Person person = new Person(id: personId, name: "Zbigniew", surname: "Hołdys", email: "zh@gmail.com", password: "abc", role: "user")
            Room room = new Room(id: roomId, roomNumber: "1", numberOfBeds: "1")

            Reservation reservation = new Reservation()
            reservation.setId(1L)
            reservation.setStartReservationDate(LocalDate.of(2030, 10, 10))
            reservation.setEndReservationDate(LocalDate.of(2030, 10, 12))
            reservation.setPerson(person)
            reservation.setRoom(room)

        when:
            personRepository.findById(personId) >> Optional.of(person)
            roomRepository.findById(roomId) >> Optional.of(room)
            reservationRepository.save() >> reservation
            sut.createReservation(createReservationDto())

        then:
            noExceptionThrown()
    }

    private static RoomReservationDto createReservationDto() {
        return RoomReservationDto.builder()
                .startReservationDate(LocalDate.of(2030, 10, 10))
                .endReservationDate(LocalDate.of(2030, 10, 12))
                .personId(1L)
                .roomId(1L)
                .build()
    }
}
