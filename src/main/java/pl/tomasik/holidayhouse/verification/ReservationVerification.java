package pl.tomasik.holidayhouse.verification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.model.dto.RoomReservationDto;
import pl.tomasik.holidayhouse.repository.ReservationRepository;
import pl.tomasik.holidayhouse.utils.CompareDateUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationVerification {

    private final ReservationRepository reservationRepository;

    public void validate(RoomReservationDto roomReservationDto) {

        List<Reservation> reservationList = reservationRepository.findAllByRoomId(roomReservationDto.getRoomId());

        if (reservationList.isEmpty()) {
            throw new IllegalArgumentException("No booking found for id:" + roomReservationDto.getRoomId());
        }
        boolean isRoomReserved = reservationList.stream()
                .anyMatch(r -> CompareDateUtils.isDateBetweenRange(roomReservationDto.getStartReservationDate(), r.getStartReservationDate(), r.getEndReservationDate()));

        if (isRoomReserved) {
            throw new IllegalArgumentException("Room booked on this date:" + roomReservationDto.getStartReservationDate());
        }

        boolean isEndDateBeforeStart = CompareDateUtils.isDateLessThanOrEqual(roomReservationDto.getEndReservationDate(), roomReservationDto.getStartReservationDate());

        if (isEndDateBeforeStart) {
            throw new IllegalArgumentException("End date earlier than start date");
        }
    }

}
