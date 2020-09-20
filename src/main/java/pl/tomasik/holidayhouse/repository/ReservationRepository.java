package pl.tomasik.holidayhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.tomasik.holidayhouse.model.Reservation;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT res FROM Reservation res JOIN res.room roo WHERE roo.id = :id ")
    Optional<List<Reservation>> findAllByRoomId(@Param("id") Long Id);

}
