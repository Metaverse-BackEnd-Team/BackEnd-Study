package com.ohgiraffers.booking_study;

public abstract class Ticket {
    private int ticketId;
    private String eventName;
    private int price;
    private boolean isSeatAvailable;


    public Ticket() {
    }

    public Ticket(int ticketId, String eventName, int price) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.price = price;
        this.isSeatAvailable = true; // 처음에는 좌석이 예약 가능 상태
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSeatAvailable() {
        return isSeatAvailable;
    }

    public void reserveSeat() {
        if (isSeatAvailable) {
            this.isSeatAvailable = false;
            System.out.println("좌석이 예약되었습니다.");
        } else {
            System.out.println("이미 예약된 좌석입니다.");
        }
    }

    public void cancelSeatReservation() {
        this.isSeatAvailable = true;
        System.out.println("예약이 취소되었습니다.");
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "티켓 ID =" + ticketId +
                ", 이벤트 ='" + eventName + '\'' +
                ", 가격 =" + price +
                ", 좌석 예약 가능 여부 =" + isSeatAvailable +
                '}';
    }

    public abstract void book(); //티켓예약 추상 메서드
}
