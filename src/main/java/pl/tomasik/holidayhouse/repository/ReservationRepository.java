package pl.tomasik.holidayhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tomasik.holidayhouse.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {




}
