package pl.tomasik.holidayhouse.verification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.repository.ReservationRepository;
import pl.tomasik.holidayhouse.utils.CompareDateUtils;

import java.time.LocalDate;
import java.util.List;

/**
 * Class is used to check if the room has booked on this date
 */

@Component
@RequiredArgsConstructor
public class ReservationVerification {

    private final ReservationRepository reservationRepository;

    public void validate(Long roomId, LocalDate startReservationDate) {

        List<Reservation> reservationList = reservationRepository.findAllByRoomId(roomId);

        if (reservationList.isEmpty()) {
            throw new IllegalArgumentException("No booking found for id:" + roomId);
        }
        boolean isRoomReserved = reservationList.stream()
                .anyMatch(r -> CompareDateUtils.isDateBetweenRange(startReservationDate, r.getStartReservationDate(), r.getEndReservationDate()));

        if (isRoomReserved) {
            throw new IllegalArgumentException("Room booked on this date:" + startReservationDate);
        }
    }
}
