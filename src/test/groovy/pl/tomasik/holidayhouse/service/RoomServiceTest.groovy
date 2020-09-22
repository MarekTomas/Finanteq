package pl.tomasik.holidayhouse.service

import pl.tomasik.holidayhouse.model.Reservation
import pl.tomasik.holidayhouse.model.Room
import pl.tomasik.holidayhouse.repository.RoomRepository
import spock.lang.Specification

import java.time.LocalDate

class RoomServiceTest extends Specification {
    RoomRepository roomRepository = Mock()
    RoomService sut = [roomRepository]

    def "should return room by id"() {
        setup:
            Long id = 1L
            Room room = new Room(id: 1l, roomNumber: 1, numberOfBeds: 1, conectedReservation: [createReservationStub()])
        when:
            roomRepository.findById(id) >> Optional.of(room)
            sut.findByRoomId(id)
        then:
            noExceptionThrown()
    }

    def "should return all room"() {
        setup:
            Room room = new Room(id: 1l, roomNumber: 1, numberOfBeds: 1, conectedReservation: [createReservationStub()])
        when:
            roomRepository.findAll() >> [room]
            sut.findAllRooms()
        then:
            noExceptionThrown()
    }

    private static Reservation createReservationStub() {
        Reservation reservation = new Reservation()
        reservation.setId(1L)
        reservation.setStartReservationDate(LocalDate.now().plusDays(20))
        reservation.setEndReservationDate(LocalDate.now().plusDays(50))
        return reservation
    }
}
