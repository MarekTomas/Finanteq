package pl.tomasik.holidayhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.tomasik.holidayhouse.model.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT res FROM Reservation res JOIN res.room roo WHERE roo.id = :id ")
    List<Reservation> findAllByRoomId(@Param("id") Long id);


    @Query("SELECT res FROM Reservation res JOIN res.room roo JOIN res.person per WHERE roo.id = :roomId and per.id = :personId and res.startReservationDate = :startDate")
    Optional<Reservation> findByRoomIdPersonIdAndStartDate(@Param("roomId") Long roomId, @Param("personId") Long personId, @Param("startDate") LocalDate startDate);

    @Query("SELECT res FROM Reservation res JOIN res.person")
    List<Reservation> findAllReservationWithPerson();

}
