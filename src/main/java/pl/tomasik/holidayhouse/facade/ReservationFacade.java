package pl.tomasik.holidayhouse.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.factory.ReservationFactory;
import pl.tomasik.holidayhouse.verification.ReservationVerification;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ReservationFacade {

    private final ReservationFactory reservationFactory;
    private final ReservationVerification reservationVerification;

    public void execute(Long roomId, LocalDate startReservationDate, LocalDate endReservationDate, Long personId) {
        reservationVerification.validate(roomId, startReservationDate);
        reservationFactory.createReservation(roomId, startReservationDate, endReservationDate, personId);
    }
}
