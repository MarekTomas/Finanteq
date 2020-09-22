package pl.tomasik.holidayhouse.service

import pl.tomasik.holidayhouse.model.Reservation
import pl.tomasik.holidayhouse.repository.ReservationRepository
import pl.tomasik.holidayhouse.service.DeleteReservationService
import spock.lang.Specification

import java.time.LocalDate

class DeleteReservationServiceTest extends Specification {

    ReservationRepository reservationRepository = Mock()
    DeleteReservationService sut =[reservationRepository]

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
