package pl.tomasik.holidayhouse.model.dto;

import lombok.Builder;
import lombok.Getter;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.model.Room;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class RoomResultDto {

    private String roomNumber;
    private String numberOfBeds;
    private List<ReservationResultDto> reservationResultDtos;

    public static RoomResultDto of(Room room){
        return RoomResultDto.builder()
                .roomNumber(room.getRoomNumber())
                .numberOfBeds(room.getNumberOfBeds())
                .reservationResultDtos(createReservations(room.getConectedReservation()))
                .build();
    }

    private static List<ReservationResultDto> createReservations(List<Reservation> reservationEntities){
        return reservationEntities.stream().map(RoomResultDto::createReservation).collect(Collectors.toList());
    }

    private static ReservationResultDto createReservation(Reservation reservation){
        return ReservationResultDto.builder()
                .startReservationDate(reservation.getStartReservationDate())
                .endReservationDate(reservation.getEndReservationDate())
                .build();
    }
}
