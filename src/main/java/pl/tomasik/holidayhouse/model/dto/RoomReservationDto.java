package pl.tomasik.holidayhouse.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class RoomReservationDto {

    private LocalDate startReservationDate;
    private LocalDate endReservationDate;
    private Long personId;
    private Long roomId;

}
