package pl.tomasik.holidayhouse.sendreminder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.repository.ReservationRepository;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationChecker {

    private final ReservationRepository reservationRepository;

    public void execute() {
        List<Reservation> reservationList = reservationRepository.findAllReservationWithPerson();

        for (Reservation reservation : reservationList) {
            if (reservation.getStartReservationDate().equals(LocalDate.now().minusDays(1))) {
                try {
                    ReservationReminder.sendEmail(reservation.getPerson().getEmail());
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
