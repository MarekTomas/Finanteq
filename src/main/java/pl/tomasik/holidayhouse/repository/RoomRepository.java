package pl.tomasik.holidayhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tomasik.holidayhouse.model.Room;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {


    Optional<Room> findByRoomNumber(int roomNumber);

}
