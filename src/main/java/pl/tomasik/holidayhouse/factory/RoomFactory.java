package pl.tomasik.holidayhouse.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.Room;
import pl.tomasik.holidayhouse.repository.RoomRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoomFactory {

    private final RoomRepository roomRepository;

    public Room findById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room id not found:" + id));
    }

    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }
}
