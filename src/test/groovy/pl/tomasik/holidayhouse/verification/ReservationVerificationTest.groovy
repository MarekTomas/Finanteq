package pl.tomasik.holidayhouse.verification

import pl.tomasik.holidayhouse.model.Reservation
import pl.tomasik.holidayhouse.repository.ReservationRepository
import spock.lang.Specification

import java.time.LocalDate

class ReservationVerificationTest extends Specification {

    ReservationRepository reservationRepository = Mock()
    ReservationVerification sut = [reservationRepository]

    def "should return all reservation by room id"() {
        setup:
            Long id = 1L
            LocalDate start = LocalDate.now()

        when:
            reservationRepository.findAllByRoomId(_ as Long) >> [createReservationStub()]
            sut.validate(id, start)

        then:
            noExceptionThrown()
    }

    def "should return exception when will not find reservation by room id"() {
        setup:
        Long id = 1L
        LocalDate start = LocalDate.now()

        when:
        reservationRepository.findAllByRoomId(_ as Long) >> Collections.emptyList()
        sut.validate(id, start)

        then:
        thrown(IllegalArgumentException)
    }

    def "should return exception when date reservation is in range"() {
        setup:
        Long id = 1L
        LocalDate start = LocalDate.now()

        when:
        reservationRepository.findAllByRoomId(_ as Long) >> [createReservationInRangeStub()]
        sut.validate(id, start)

        then:
        thrown(IllegalArgumentException)
    }

    private static Reservation createReservationStub(){
        Reservation reservation = new Reservation()
        reservation.setId(1L)
        reservation.setStartReservationDate(LocalDate.of(2030,10,10))
        reservation.setEndReservationDate(LocalDate.of(2030,10,12))
        return reservation
    }

    private static Reservation createReservationInRangeStub(){
        Reservation reservation = new Reservation()
        reservation.setId(1L)
        reservation.setStartReservationDate(LocalDate.now())
        reservation.setEndReservationDate(LocalDate.now().plusDays(1))
        return reservation
    }
}
