package pl.tomasik.holidayhouse.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomasik.holidayhouse.model.Reservation;
import pl.tomasik.holidayhouse.model.dto.RoomReservationDto;
import pl.tomasik.holidayhouse.repository.ReservationRepository;
import pl.tomasik.holidayhouse.service.ReservationService;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DeleteRoomReservationTestIT {
    @Autowired
    HolidayHouseController holidayHouseController;

    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationRepository repository;

    @Test
    void shouldSaveRoomReservation() {
        RoomReservationDto roomReservationDto = createRoomReservationDto();
        holidayHouseController.roomReservation(roomReservationDto);

        Reservation reservation = reservationService.createReservation(roomReservationDto);
        Reservation reservationResult = repository.save(reservation);
        assertThat(reservationResult.getStartReservationDate()).isEqualTo(roomReservationDto.getStartReservationDate());
        assertThat(reservationResult.getEndReservationDate()).isEqualTo(roomReservationDto.getEndReservationDate());
        assertThat(reservationResult.getPerson().getId()).isEqualTo(roomReservationDto.getPersonId());
        assertThat(reservationResult.getRoom().getId()).isEqualTo(roomReservationDto.getRoomId());
    }

    private static RoomReservationDto createRoomReservationDto() {
        return RoomReservationDto.builder()
                .roomId(1L)
                .personId(1L)
                .startReservationDate(LocalDate.now())
                .endReservationDate(LocalDate.now().plusDays(10))
                .build();
    }
}
