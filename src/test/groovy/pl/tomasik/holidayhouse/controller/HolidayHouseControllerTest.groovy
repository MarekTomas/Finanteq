package pl.tomasik.holidayhouse.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import pl.tomasik.holidayhouse.facade.DeleteReservationFacade
import pl.tomasik.holidayhouse.facade.ReservationFacade
import pl.tomasik.holidayhouse.model.dto.ReservationResultDto
import pl.tomasik.holidayhouse.model.dto.RoomResultDto
import pl.tomasik.holidayhouse.sendreminder.ReservationChecker
import pl.tomasik.holidayhouse.service.RoomService
import spock.lang.Specification

import java.time.LocalDate

import static pl.tomasik.holidayhouse.controller.BussinesMessage.RESERVATION_DELETE
import static pl.tomasik.holidayhouse.controller.BussinesMessage.ROOM_BOOKED
import static pl.tomasik.holidayhouse.controller.BussinesMessage.SENDER_REMINDER

class HolidayHouseControllerTest extends Specification {

    RoomService roomService = Mock()
    ReservationFacade reservationFacade = Mock()
    ReservationChecker reservationChecker = Mock()
    DeleteReservationFacade deleteReservationfacade = Mock()

    HolidayHouseController sut = [roomService, reservationFacade, reservationChecker, deleteReservationfacade]

    def "should return room by id"() {
        setup:
            Long roomId = 1L
            RoomResultDto dto = createRoomResultDto()
            ResponseEntity expectedResult = new ResponseEntity(dto, HttpStatus.OK)

        when:
            roomService.findByRoomId(roomId) >> dto
            def result = sut.getRoomBy(roomId)

        then:
            result == expectedResult
    }

    def "should return all rooms"() {
        setup:
            RoomResultDto dto = createRoomResultDto()
            ResponseEntity expectedResult = new ResponseEntity([dto], HttpStatus.OK)

        when:
            roomService.findAllRooms() >> [dto]
            def result = sut.getAllRooms()

        then:
            result == expectedResult
    }

    def "should return room reservation"() {
        setup:
            Long roomId = 1L
            Long personId = 1L
            LocalDate startDate = LocalDate.of(2030, 10, 10)
            LocalDate endDate = LocalDate.of(2030, 10, 12)
            ResponseEntity expectedResult = new ResponseEntity(ROOM_BOOKED.getMessage(), HttpStatus.OK)

        when:
            reservationFacade.execute(roomId, startDate, endDate, personId)
            def result = sut.roomReservation(roomId, startDate, endDate, personId)

        then:
            result == expectedResult
    }

    def "should delete reservation"() {
        setup:
            Long roomId = 1L
            Long personId = 1L
            LocalDate startDate = LocalDate.of(2030, 10, 10)
            ResponseEntity expectedResult = new ResponseEntity(RESERVATION_DELETE.getMessage(), HttpStatus.OK)

        when:
            deleteReservationfacade.execute(roomId, personId, startDate)
            def result = sut.deleteRoomReservation(roomId, personId, startDate)

        then:
            result == expectedResult
    }

    def "should execute sender reminder"() {
        setup:
            ResponseEntity expectedResult = new ResponseEntity(SENDER_REMINDER.getMessage(), HttpStatus.OK)

        when:
            reservationChecker.execute()
            def result = sut.runSenderReminder()

        then:
            result == expectedResult
    }

    private static RoomResultDto createRoomResultDto() {
        return RoomResultDto.builder()
                .roomNumber("1")
                .numberOfBeds("1")
                .reservationResultDtos([createReservationResultDto()])
                .build()
    }

    private static ReservationResultDto createReservationResultDto() {
        return ReservationResultDto.builder()
                .startReservationDate(LocalDate.of(2030, 10, 10))
                .endReservationDate(LocalDate.of(2030, 10, 12))
                .build()
    }
}
