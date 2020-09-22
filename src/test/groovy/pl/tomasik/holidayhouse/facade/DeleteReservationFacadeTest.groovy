package pl.tomasik.holidayhouse.facade

import pl.tomasik.holidayhouse.model.Reservation
import pl.tomasik.holidayhouse.model.dto.DeleteReservationDto
import pl.tomasik.holidayhouse.service.DeleteReservationExecuteService
import pl.tomasik.holidayhouse.service.DeleteReservationService
import spock.lang.Specification

import java.time.LocalDate

class DeleteReservationFacadeTest extends Specification {

    DeleteReservationService deleteReservationService = Stub()
    DeleteReservationExecuteService deleteReservationExecuteService = Mock()

    DeleteReservationFacade sut = [deleteReservationService, deleteReservationExecuteService]

    def "should execute factory and verification"() {
        setup:
            Reservation reservation = new Reservation(id: 1L)

        when:
            deleteReservationService.getReservation(createDeleteReservationDto()) >> reservation
            deleteReservationExecuteService.execute(reservation.getId())
            sut.execute(createDeleteReservationDto())

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
