package pl.tomasik.holidayhouse.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.Room;
import pl.tomasik.holidayhouse.repository.RoomRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class ReservationFactory {

    private final RoomRepository roomRepository;

    public Room createReservation (int roomNnumber, LocalDate startReservationDate, LocalDate endReservationDate) {

        var room = roomRepository.findByRoomNumber(roomNnumber)
                .orElseThrow(() -> new IllegalArgumentException("Room number not found:" + roomNnumber));

       /* room.setReserved(true);
        room.setStartReservationDate(startReservationDate);
        room.setEndReservationDate(endReservationDate);*/

        return roomRepository.save(room);
    }
}
