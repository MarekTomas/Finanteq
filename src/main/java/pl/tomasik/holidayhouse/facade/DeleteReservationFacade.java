package pl.tomasik.holidayhouse.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomasik.holidayhouse.verification.DeleteVerification;

@Component
@RequiredArgsConstructor
public class DeleteReservationFacade {

    private final DeleteVerification deleteVerification;

    public void execute(Long roomId, Long personId) {
        deleteVerification.validate(roomId, personId);

    }
}
