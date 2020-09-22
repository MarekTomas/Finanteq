package pl.tomasik.holidayhouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tomasik.holidayhouse.repository.ReservationRepository;

@Service
@RequiredArgsConstructor
public class DeleteReservationExecuteService {

    private final ReservationRepository reservationRepository;

    public void execute(Long reservationId){
        reservationRepository.deleteById(reservationId);
    }
}
