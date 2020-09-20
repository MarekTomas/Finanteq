package pl.tomasik.holidayhouse.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BussinesMessage {

    ROOM_BOOKED("Room booked successfully.");

    private final String message;
}
