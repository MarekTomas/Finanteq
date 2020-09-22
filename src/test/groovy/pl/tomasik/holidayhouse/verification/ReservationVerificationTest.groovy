package pl.tomasik.holidayhouse.verification

import pl.tomasik.holidayhouse.model.Reservation
import pl.tomasik.holidayhouse.model.dto.RoomReservationDto
import pl.tomasik.holidayhouse.repository.ReservationRepository
import spock.lang.Specification

import java.time.LocalDate

class ReservationVerificationTest extends Specification {

    ReservationRepository reservationRepository = Mock()
    ReservationVerification sut = [reservationRepository]

    def "should return exception when will not find reservation by room id"() {

        when:
        reservationRepository.findAllByRoomId(_ as Long) >> Collections.emptyList()
        sut.validate(createReservationDto())

        then:
        thrown(IllegalArgumentException)
    }

    def "should return exception when date reservation is in range"() {

        when:
        reservationRepository.findAllByRoomId(_ as Long) >> [createReservationStub(createReservationDto().startReservationDate, createReservationDto().endReservationDate)]
        sut.validate(createReservationDto())

        then:
        thrown(IllegalArgumentException)
    }
    def "should return exception when end date reservation earlier than start date"() {
        setup:


        when:
        reservationRepository.findAllByRoomId(_ as Long) >> [createReservationStub(createReservationDto().startReservationDate, createReservationDto().endReservationDate)]
        sut.validate(createReservationDto())

        then:
        thrown(IllegalArgumentException)
    }

    private static Reservation createReservationStub(LocalDate start,LocalDate end){
        Reservation reservation = new Reservation()
        reservation.setId(1L)
        reservation.setStartReservationDate(start)
        reservation.setEndReservationDate(end)
        return reservation
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
