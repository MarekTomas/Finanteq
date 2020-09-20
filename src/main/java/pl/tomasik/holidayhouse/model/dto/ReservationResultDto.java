package pl.tomasik.holidayhouse.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class ReservationResultDto {

    private LocalDate startReservationDate;
    private LocalDate endReservationDate;
}
