package pl.tomasik.holidayhouse.facade

import pl.tomasik.holidayhouse.factory.DeleteReservationFactory
import pl.tomasik.holidayhouse.model.Reservation
import pl.tomasik.holidayhouse.service.DeleteReservationService
import spock.lang.Specification

import java.time.LocalDate

class DeleteReservationFacadeTest extends Specification {

    DeleteReservationFactory deleteReservationFactory = Mock()
    DeleteReservationService deleteReservationService = Mock()

    DeleteReservationFacade sut = [deleteReservationFactory, deleteReservationService]

    def "should execute factory and verification"() {
        setup:
            Long roomId = 1L
            Long personId = 1L
            LocalDate startDate = LocalDate.of(2030, 10, 10)
            Reservation reservation = new Reservation(id: 1L)

        when:
            deleteReservationFactory.getReservation(roomId, personId, startDate) >> reservation
            deleteReservationService.execute(reservation.getId())
            sut.execute(roomId, personId, startDate)

        then:
            noExceptionThrown()
    }
}
