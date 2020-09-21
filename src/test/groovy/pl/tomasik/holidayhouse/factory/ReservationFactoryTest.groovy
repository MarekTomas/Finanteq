package pl.tomasik.holidayhouse.factory

import pl.tomasik.holidayhouse.model.Person
import pl.tomasik.holidayhouse.model.Reservation
import pl.tomasik.holidayhouse.model.Room
import pl.tomasik.holidayhouse.repository.PersonRepository
import pl.tomasik.holidayhouse.repository.ReservationRepository
import pl.tomasik.holidayhouse.repository.RoomRepository
import spock.lang.Specification

import java.time.LocalDate

class ReservationFactoryTest extends Specification {

   /* RoomRepository roomRepository = Mock()
    PersonRepository personRepository = Mock()
    ReservationRepository reservationRepository = Mock()
    ReservationFactory sut = [roomRepository, personRepository, reservationRepository]

    def "should create reservation"() {
        setup:
        Long roomId = 1L
        Long personId = 1L
        LocalDate startDate = LocalDate.of(2030,10,10)
        LocalDate endDate =  LocalDate.of(2030,10,12)

        Person person = new Person(id: personId,name: "Zbigniew",surname: "Hołdys",email: "zh@gmail.com",password: "abc",role: "user",reservationEntities: [_ as Reservation])
        Room room = new Room(id:roomId,roomNumber: "1",numberOfBeds: "1")

        Reservation reservation = new Reservation()
        reservation.setId(1L)
        reservation.setStartReservationDate(LocalDate.of(2030,10,10))
        reservation.setEndReservationDate(LocalDate.of(2030,10,12))
        reservation.setPerson(person)
        reservation.setRoom(room)

        when:
        personRepository.findById(personId) >> Optional.of(person)
        roomRepository.findById() >> Optional.of(room)
        reservationRepository.save() >> reservation
        sut.createReservation(roomId, startDate,endDate,personId)

        then:
        noExceptionThrown()
    }*/
}
