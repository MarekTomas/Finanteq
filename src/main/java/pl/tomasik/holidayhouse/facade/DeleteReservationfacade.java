package pl.tomasik.holidayhouse.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.Room;
import pl.tomasik.holidayhouse.repository.RoomRepository;

@Component
@RequiredArgsConstructor
public class DeleteReservationfacade {

    private final RoomRepository roomRepository;

    public Room deleteReservation(Room room){
        return roomRepository.save(room);
    }
}
