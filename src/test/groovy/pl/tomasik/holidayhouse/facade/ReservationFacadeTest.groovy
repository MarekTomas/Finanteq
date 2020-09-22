package pl.tomasik.holidayhouse.facade

import pl.tomasik.holidayhouse.model.dto.RoomReservationDto
import pl.tomasik.holidayhouse.service.ReservationService
import pl.tomasik.holidayhouse.verification.ReservationVerification
import spock.lang.Specification

import java.time.LocalDate

class ReservationFacadeTest extends Specification {

    ReservationService reservationFactory = Mock()
    ReservationVerification reservationVerification = Mock()

    ReservationFacade sut = [reservationFactory, reservationVerification]

    def "should execute factory and verification"() {

        when:
            reservationVerification.validate(createReservationDto())
            reservationFactory.createReservation(createReservationDto())
            sut.execute(createReservationDto())

        then:
        noExceptionThrown()
    }

    private static RoomReservationDto createReservationDto() {
        return RoomReservationDto.builder()
                .startReservationDate(LocalDate.of(2030, 10, 10))
                .endReservationDate(LocalDate.of(2030, 10, 12))
                .personId(1L)
                .roomId(1L)
                .build()
    }

}
