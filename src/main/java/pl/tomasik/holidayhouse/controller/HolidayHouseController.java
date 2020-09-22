package pl.tomasik.holidayhouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tomasik.holidayhouse.facade.DeleteReservationFacade;
import pl.tomasik.holidayhouse.facade.ReservationFacade;
import pl.tomasik.holidayhouse.model.dto.DeleteReservationDto;
import pl.tomasik.holidayhouse.model.dto.RoomReservationDto;
import pl.tomasik.holidayhouse.model.dto.RoomResultDto;
import pl.tomasik.holidayhouse.sendreminder.ReservationChecker;
import pl.tomasik.holidayhouse.service.RoomService;

import java.time.LocalDate;
import java.util.List;

import static pl.tomasik.holidayhouse.controller.BussinesMessage.RESERVATION_DELETE;
import static pl.tomasik.holidayhouse.controller.BussinesMessage.ROOM_BOOKED;
import static pl.tomasik.holidayhouse.controller.BussinesMessage.SENDER_REMINDER;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class HolidayHouseController {

    private final RoomService roomService;
    private final ReservationFacade reservationFacade;
    private final ReservationChecker reservationChecker;
    private final DeleteReservationFacade deleteReservationfacade;

    @GetMapping("/{id}")
    public ResponseEntity<RoomResultDto> getRoomBy(@PathVariable Long id) {
        return new ResponseEntity(roomService.findByRoomId(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<RoomResultDto>> getAllRooms() {
        return new ResponseEntity(roomService.findAllRooms(), HttpStatus.OK);
    }

    @PostMapping("/reservation")
    public ResponseEntity<RoomResultDto> roomReservation(@RequestBody RoomReservationDto roomReservationDto) {
        reservationFacade.execute(roomReservationDto);
        return new ResponseEntity(ROOM_BOOKED.getMessage(), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteRoomReservation(@RequestBody DeleteReservationDto deleteReservationDto) {
        deleteReservationfacade.execute(deleteReservationDto);
        return new ResponseEntity(RESERVATION_DELETE.getMessage(), HttpStatus.OK);
    }

    @PostMapping("/senderReminder")
    public ResponseEntity<Void> runSenderReminder() {
        reservationChecker.execute();
        return new ResponseEntity(SENDER_REMINDER.getMessage(), HttpStatus.OK);
    }

}
