package com.ohgiraffers.booking_study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReservationManager {

    //사용자별 예약 목록 저장하는 Map
    private HashMap<String, List<Ticket>> userReservations = new HashMap<>();

    // 특정 사용자가 티켓을 예약하는 메서드
    public void reserveTicket(String userName, Ticket ticket) {
        // userReservations에서 userName에 해당하는 예약 목록을 찾고,
        // 없으면 빈 리스트를 기본값으로 반환
        List<Ticket> userTickets = userReservations.getOrDefault(userName, new ArrayList<>());

        userTickets.add(ticket);
        userReservations.put(userName, userTickets);
        System.out.println(userName + "님이 " + ticket.getEventName() + " 티켓을 예약했습니다.");
    }

    // 특정 사용자의 예약 목록을 조회하는 메서드
    public List<Ticket> getUserReservation(String userName) {
        return userReservations.getOrDefault(userName, new ArrayList<>());
    }

    // 특정 사용자의 예약을 취소하는 메서드
    public void removeTicket(String userName, Ticket ticket) {
        List<Ticket> userTickets = userReservations.getOrDefault(userName, new ArrayList<>());
        userTickets.remove(ticket);
        userReservations.put(userName, userTickets);
    }

    // 특정 사용자의 예약 내역을 출력하는 메서드
    public void showUserReservations(String userName) {
        List<Ticket> userTickets = getUserReservation(userName);
        if (userTickets.isEmpty()) {
            System.out.println(userName + "님의 예약 내역이 없습니다.");
        } else {
            System.out.println(userName + "님의 예약 내역:");
            for (Ticket ticket : userTickets) {
                System.out.println(ticket);
            }
        }
    }

}
