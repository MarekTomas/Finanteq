package pl.tomasik.holidayhouse.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.factory.DeleteReservationFactory;
import pl.tomasik.holidayhouse.service.DeleteReservationService;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DeleteReservationFacade {

    private final DeleteReservationFactory deleteReservationFactory;
    private final DeleteReservationService deleteReservationService;

    public void execute(Long roomId, Long personId, LocalDate startReservationDate) {
        var reservation = deleteReservationFactory.getReservation(roomId, personId, startReservationDate);
        deleteReservationService.execute(reservation.getId());
    }
}
