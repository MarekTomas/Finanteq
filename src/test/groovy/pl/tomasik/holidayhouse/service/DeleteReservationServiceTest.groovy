package pl.tomasik.holidayhouse.service


import pl.tomasik.holidayhouse.repository.ReservationRepository
import spock.lang.Specification

class DeleteReservationServiceTest extends Specification {

    ReservationRepository reservationRepository = Mock()
    DeleteReservationService sut = [reservationRepository]

    def "should return all room"() {
        setup:
            Long reservationId = 1L

        when:
            reservationRepository.deleteById(reservationId)
            sut.execute(reservationId)

        then:
            noExceptionThrown()
    }
}
