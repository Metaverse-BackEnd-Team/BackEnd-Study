package com.ohgiraffers.booking_study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    void ticketBookingTest() {
        Ticket movieTicket = new MovieTicket(1, "태극기 휘날리며", 10000);
        Ticket flightTicket = new FlightTicket(2, "서울행", 2000);

        movieTicket.book();
        flightTicket.book();

        assertEquals("태극기 휘날리며", movieTicket.getEventName());
        assertEquals("서울행", flightTicket.getEventName());



    }
}
