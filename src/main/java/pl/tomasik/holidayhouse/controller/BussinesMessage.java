package pl.tomasik.holidayhouse.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BussinesMessage {

    ROOM_BOOKED("Room booked successfully."),
    RESERVATION_DELETE("Reservation delete successfully."),
    SENDER_REMINDER("Sender Reminder run successfully.");

    private final String message;
}
