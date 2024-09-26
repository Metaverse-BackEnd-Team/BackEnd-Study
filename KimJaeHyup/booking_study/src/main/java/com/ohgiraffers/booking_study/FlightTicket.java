package com.ohgiraffers.booking_study;

public class FlightTicket extends Ticket {

    public FlightTicket(int ticketId, String eventName, int price) {
        super(ticketId, eventName, price);
    }

    @Override
    public void book() {
        System.out.println("항공편 " + getEventName() + "의 티켓이 예약되었습니다.");
    }
}
