package pl.tomasik.holidayhouse.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.repository.ReservationRepository;

import java.time.LocalDate;

/**
 * Class is used to check if the reservation cen be delete
 */
@Component
@RequiredArgsConstructor
public class DeleteReservationFactory {

    private final ReservationRepository reservationRepository;

    public Reservation getReservation(Long roomId, Long personId, LocalDate startReservationDate) {
        return reservationRepository.findByRoomIdPersonIdAndStartDate(roomId, personId, startReservationDate)
                .orElseThrow(() -> new IllegalArgumentException
                        ("There is no reservation for person with id: " + personId + " roomId: " + roomId + " and date: " + startReservationDate));
    }
}
