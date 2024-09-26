package com.ohgiraffers.booking_study;

public class MovieTicket extends Ticket {

    public MovieTicket(int ticketId, String eventName, int price) {
        super(ticketId, eventName, price);
    }

    @Override
    public void book(){
        System.out.println("영화 " + getEventName() + "의 티켓이 예약되었습니다.");
    }
}
