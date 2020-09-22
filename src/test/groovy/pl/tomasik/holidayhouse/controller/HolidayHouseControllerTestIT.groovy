package pl.tomasik.holidayhouse.controller


import spock.lang.Specification

/*@SpringBootTest
@Transactional
@AutoConfigureMockMvc*/
class HolidayHouseControllerTestIT extends Specification {
/*
    @Autowired
    ReservationFacade reservationFacade

    @Autowired
    HolidayHouseController controller

    @Autowired
    ReservationRepository repository

    @Autowired
    ReservationFactory reservationFactory

    def "should return room reservation"() {
        setup:
        Long roomId = 1L
        Long personId = 1L
        LocalDate startDate = LocalDate.of(2030, 10, 10)
        LocalDate endDate = LocalDate.of(2030, 10, 12)

        when:
        roomId ==1
        controller.roomReservation(roomId, startDate, endDate, personId)
        repository.findAll()
        //Reservation reservation = reservationFactory.createReservation(roomId,startDate,endDate,personId)

        then:
        noExceptionThrown()
        repository.findAll().size() == 1
        *//*reservation.getId() == roomId
        reservation.getStartReservationDate() == startDate
        reservation.getEndReservationDate() == endDate
        reservation.getPerson()
        reservation.getRoom()*//*
    }*/
}
