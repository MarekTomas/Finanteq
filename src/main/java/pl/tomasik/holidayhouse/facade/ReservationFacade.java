package pl.tomasik.holidayhouse.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.dto.RoomReservationDto;
import pl.tomasik.holidayhouse.service.ReservationService;
import pl.tomasik.holidayhouse.verification.ReservationVerification;

@Component
@RequiredArgsConstructor
public class ReservationFacade {

    private final ReservationService reservationService;
    private final ReservationVerification reservationVerification;

    public void execute(RoomReservationDto roomReservationDto) {
        reservationVerification.validate(roomReservationDto);
        reservationService.createReservation(roomReservationDto);
    }
}
