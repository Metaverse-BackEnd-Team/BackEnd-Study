package com.ohgiraffers.booking_study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationManagerTest {

    @Test
    @DisplayName("사용자가 티켓을 예약하면 예약 내역에 성공적으로 추가되어야 한다.")
    void reserveTicket() {
        //given
        ReservationManager reservationManager = new ReservationManager();
        Ticket movieTicket = new MovieTicket(1, "울산행", 1000);

        //when
        reservationManager.reserveTicket("김재협", movieTicket);

        //then: 예약 내역에 티켓이 추가되었는지 확인
        assertEquals(1, reservationManager.getUserReservation("김재협").size());
        assertEquals("울산행", reservationManager.getUserReservation("김재협").get(0).getEventName());
    }

    @Test
    @DisplayName("사용자가 티켓 예약을 취소하면 예약 목록에서 해당 티켓이 제거되어야 한다.")
    void removeTicket() {
        //given
        ReservationManager reservationManager = new ReservationManager();
        Ticket movieTicket1 = new MovieTicket(1, "울산행1", 1000);
        Ticket movieTicket2 = new MovieTicket(2, "울산행2", 1000);
        reservationManager.reserveTicket("김재협", movieTicket1);
        reservationManager.reserveTicket("김재협", movieTicket2);

        //when
        reservationManager.removeTicket("김재협", movieTicket1);


        //then
        assertEquals(1, reservationManager.getUserReservation("김재협").size());
    }

    @Test
    @DisplayName("사용자가 티켓을 예약하면 좌석은 예약 불가 상태가 되어야 한다.")
    void checkTicketAvailability() {

        // given: 예약 가능한 티켓을 준비
        Ticket movieTicket1 = new MovieTicket(1, "울산행1", 1000);
        assertTrue(movieTicket1.isSeatAvailable()); // 처음에는 좌석이 예약 가능 상태

        // when: 사용자가 티켓을 예약
        movieTicket1.reserveSeat();

        //then
        assertFalse(movieTicket1.isSeatAvailable());
    }
}