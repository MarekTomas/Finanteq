package pl.tomasik.holidayhouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.model.dto.DeleteReservationDto;
import pl.tomasik.holidayhouse.repository.ReservationRepository;

@Component
@RequiredArgsConstructor
public class DeleteReservationService {

    private final ReservationRepository reservationRepository;

    public Reservation getReservation(DeleteReservationDto deleteReservationDto) {
        return reservationRepository.findByRoomIdPersonIdAndStartDate(deleteReservationDto.getRoomId(), deleteReservationDto.getPersonId(), deleteReservationDto.getStartReservationDate())
                .orElseThrow(() -> new IllegalArgumentException
                        ("There is no reservation for person with id: " +
                                deleteReservationDto.getPersonId() + " roomId: " +
                                deleteReservationDto.getRoomId() + " and date: " +
                                deleteReservationDto.getStartReservationDate()));
    }
}
