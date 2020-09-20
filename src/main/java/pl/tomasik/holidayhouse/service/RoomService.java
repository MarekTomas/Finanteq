package pl.tomasik.holidayhouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tomasik.holidayhouse.model.dto.RoomResultDto;
import pl.tomasik.holidayhouse.repository.RoomRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class used for find rooms
 */

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomResultDto findByRoomNumber(Long id) {
        return roomRepository.findById(id)
                .map(RoomResultDto::of)
                .orElseThrow(() -> new IllegalArgumentException("Room id not found:" + id));
    }

    public List<RoomResultDto> findAllRooms() {
        return roomRepository.findAll().stream()
                .map(RoomResultDto::of)
                .collect(Collectors.toList());
    }
}
