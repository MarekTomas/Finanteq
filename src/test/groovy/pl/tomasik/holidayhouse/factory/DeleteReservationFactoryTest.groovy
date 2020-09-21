package pl.tomasik.holidayhouse.factory

import pl.tomasik.holidayhouse.model.Reservation
import pl.tomasik.holidayhouse.repository.ReservationRepository
import spock.lang.Specification

import java.time.LocalDate

class DeleteReservationFactoryTest extends Specification {

    ReservationRepository reservationRepository = Mock()
    DeleteReservationFactory sut =[reservationRepository]

    def "should delete reservation by id"() {
        setup:
            Long roomId = 1L
            Long personId = 1L
            LocalDate startDate = LocalDate.of(2030, 10, 10)
            Reservation reservation = new Reservation()

        when:
            reservationRepository.findByRoomIdPersonIdAndStartDate(roomId,personId,startDate) >> Optional.of(reservation)
            sut.getReservation(roomId,personId,startDate)

        then:
            noExceptionThrown()
    }
}
