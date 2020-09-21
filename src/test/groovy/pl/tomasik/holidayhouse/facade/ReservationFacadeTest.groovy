package pl.tomasik.holidayhouse.facade

import pl.tomasik.holidayhouse.factory.ReservationFactory
import pl.tomasik.holidayhouse.verification.ReservationVerification
import spock.lang.Specification

import java.time.LocalDate

class ReservationFacadeTest extends Specification {

    ReservationFactory reservationFactory = Mock()
    ReservationVerification reservationVerification = Mock()

    ReservationFacade sut = [reservationFactory, reservationVerification]

    def "should execute factory and verification"() {
        setup:
            Long roomId = 1L
            Long personId = 1L
            LocalDate startDate = LocalDate.of(2030, 10, 10)
            LocalDate endDate = LocalDate.of(2030, 10, 12)

        when:
            reservationVerification.validate(roomId, startDate)
            reservationFactory.createReservation(roomId, startDate, endDate, personId)
            sut.execute(roomId, startDate, endDate, personId)

        then:
        noExceptionThrown()
    }

}
