package pl.tomasik.holidayhouse.verification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.repository.ReservationRepository;
import pl.tomasik.holidayhouse.utils.CompareDateUtils;

import java.util.List;

/**
 * Class is used to check if the reservation cen be delete
 */
@Component
@RequiredArgsConstructor
public class DeleteVerification {

    private final ReservationRepository reservationRepository;

    public void validate(Long roomId, Long PersonId) {

        Reservation reservationList = reservationRepository.findAllByRoomId(roomId)
                .orElseThrow(() -> new IllegalArgumentException("No booking found for id:" + roomId));

        boolean isRoomReserved = reservationList.stream()
                .anyMatch(r -> CompareDateUtils.isDateBetweenRange(startReservationDate, r.getStartReservationDate(), r.getEndReservationDate()));

        if (isRoomReserved) {
            throw new IllegalArgumentException("Room booked on this date:" + startReservationDate);
        }
    }
}
