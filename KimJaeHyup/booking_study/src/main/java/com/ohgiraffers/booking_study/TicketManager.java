package com.ohgiraffers.booking_study;

import com.ohgiraffers.booking_study.exception.InvalidNameException;
import com.ohgiraffers.booking_study.exception.InvalidPriceException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketManager<T extends Ticket> {
    private List<T> tickets = new ArrayList<>();

    //티켓을 리스트에 추가하는 메서드
    public void addTicket(T ticket) throws InvalidPriceException, InvalidNameException {

        validateTicket(ticket);  // 입력된 티켓을 검증

    }

    //티켓 가격, 이름 검증 메서드
    public void validateTicket(T ticket) throws InvalidPriceException, InvalidNameException {
        if (ticket.getPrice() <= 0) {
            throw new InvalidPriceException("티켓 가격은 0원 이상이어야 함");
        }

        if(ticket.getEventName() == null || ticket.getEventName().isEmpty()) {
            throw new InvalidNameException("티켓 이름 올바르지 않음");
        }
    }

    //저장된 티켓을 출력하는 메서드(예외 처리 추가)
    public void showTickets() {
        try {
            if (tickets.isEmpty()) {
                throw new IllegalStateException(("티켓 목록 비었음"));
            }
            for (T ticket : tickets) {
                System.out.println(ticket);
            }
        } catch (IllegalStateException e) {
            System.out.println("오류 : " + e.getMessage());
        }
    }

    public List<T> getTickets() {
        return tickets;
    }

    // 특정 가격 이하의 티켓을 필터링하는 메서드 (람다식 및 스트림 API 사용)
    public List<T> filterTicketsByPrice(int maxPrice) {

//        List<T> filteredTickets = new ArrayList<>();
//        for (T ticket : tickets) {
//            if (ticket.getPrice() <= maxPrice) {
//                filteredTickets.add(ticket);
//            }
//        }
//        return filteredTickets;

        //람다식 사용
        return tickets.stream()
                .filter(ticket -> ticket.getPrice() <= maxPrice )
                .collect(Collectors.toList());
    }
}
