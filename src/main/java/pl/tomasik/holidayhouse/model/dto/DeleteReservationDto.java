package pl.tomasik.holidayhouse.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class DeleteReservationDto {

    private LocalDate startReservationDate;
    private Long personId;
    private Long roomId;
}
