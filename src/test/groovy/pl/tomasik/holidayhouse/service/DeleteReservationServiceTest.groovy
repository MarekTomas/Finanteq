package pl.tomasik.holidayhouse.service

import pl.tomasik.holidayhouse.model.Reservation
import pl.tomasik.holidayhouse.model.dto.DeleteReservationDto
import pl.tomasik.holidayhouse.repository.ReservationRepository
import spock.lang.Specification

import java.time.LocalDate

class DeleteReservationServiceTest extends Specification {

    ReservationRepository reservationRepository = Mock()
    DeleteReservationService sut = [reservationRepository]

    def "should delete reservation by id"() {
        setup:
        Long roomId = 1L
        Long personId = 1L
        LocalDate startDate = LocalDate.of(2030, 10, 10)
        Reservation reservation = new Reservation()

        when:
        reservationRepository.findByRoomIdPersonIdAndStartDate(roomId, personId, startDate) >> Optional.of(reservation)
        sut.getReservation(createDeleteReservationDto())

        then:
        noExceptionThrown()
    }

    private static DeleteReservationDto createDeleteReservationDto() {
        return DeleteReservationDto.builder()
                .startReservationDate(LocalDate.of(2030, 10, 10))
                .personId(1L)
                .roomId(1L)
                .build()
    }
}
