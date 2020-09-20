package pl.tomasik.holidayhouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.tomasik.holidayhouse.facade.DeleteReservationfacade;
import pl.tomasik.holidayhouse.facade.ReservationFacade;
import pl.tomasik.holidayhouse.factory.RoomFactory;
import pl.tomasik.holidayhouse.model.Room;

import java.time.LocalDate;
import java.util.List;

import static pl.tomasik.holidayhouse.controller.BussinesMessage.ROOM_BOOKED;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class HolidayHouseController {

    private final RoomFactory roomFactory;
    private final ReservationFacade reservationFacade;
    private final DeleteReservationfacade deleteReservationfacade;

    @GetMapping()
    public ResponseEntity<List<Room>> roomsList(@RequestParam Long roomNumber ) {
        return new ResponseEntity(roomFactory.findById(roomNumber), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Room>> roomsList() {
        return new ResponseEntity(roomFactory.findAllRooms(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Room> roomReservation(@RequestParam int roomNumber, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startReservationDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endReservationDate ) {
        reservationFacade.execute(roomNumber,startReservationDate,endReservationDate);
        return new ResponseEntity(ROOM_BOOKED.getMessage(), HttpStatus.OK);
    }

   /* @PostMapping("/room/{id}")
    public ResponseEntity<Void> deleteRoomReserwation() {
        return new ResponseEntity(OPERACJA_ZAKONCZONA_POPRAWNIE.getMessage(), HttpStatus.OK);
    }*/

}
