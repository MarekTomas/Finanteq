package pl.tomasik.holidayhouse.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.model.dto.DeleteReservationDto;
import pl.tomasik.holidayhouse.service.DeleteReservationExecuteService;
import pl.tomasik.holidayhouse.service.DeleteReservationService;

@Component
@RequiredArgsConstructor
public class DeleteReservationFacade {

    private final DeleteReservationService deleteReservationService;
    private final DeleteReservationExecuteService deleteReservationExecuteService;

    public void execute(DeleteReservationDto deleteReservationDto) {
        Reservation reservation = deleteReservationService.getReservation(deleteReservationDto);
        deleteReservationExecuteService.execute(reservation.getId());
    }
}
