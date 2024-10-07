package com.ohgiraffers.booking_study;

import com.ohgiraffers.booking_study.exception.InvalidNameException;
import com.ohgiraffers.booking_study.exception.InvalidPriceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {


    @Test
    public void ticketManagerTest() throws InvalidPriceException, InvalidNameException {
        //given(data)
        TicketManager<Ticket> ticketManager = new TicketManager<>();
        Ticket flightTicket = new FlightTicket(1, "울산행", 1000);
        Ticket movieTicket = new MovieTicket(2, "태극기", 1000);

        //when(method)
        ticketManager.addTicket(flightTicket);
        ticketManager.addTicket(movieTicket);

        ///then(validate) 추가한 티켓이 TicketManager의 리스트에 있는지 검증
        assertEquals(2, ticketManager.getTickets().size());
        assertEquals("울산행", ticketManager.getTickets().get(0).getEventName());
        assertEquals("태극기", ticketManager.getTickets().get(1).getEventName());

    }

    @Test
    @DisplayName("가격이 0원 이하일때 오류 발생해야한다.")
    public void ticketPriceTest() throws InvalidPriceException {
        //given(data)
        TicketManager<Ticket> ticketManager = new TicketManager<>();
        Ticket invalidTicket = new MovieTicket(2, "태극기", 0);

        //when(method)

        //then
        InvalidPriceException exception = Assertions.assertThrows(
                /*예상되는 예외클래스*/InvalidPriceException.class,
                /*예외를 발생시키는 코드*/() -> {
            ticketManager.addTicket(invalidTicket);
        });

        assertEquals("티켓 가격은 0원 이상이어야 함", exception.getMessage());


    }

    @Test
    @DisplayName("티켓 이름이 빈문자열이거나 null이면 오류 발생해야한다.")
    public void ticketNameTest() throws InvalidNameException {

        //given
        TicketManager<Ticket> ticketManager = new TicketManager<>();
        Ticket invalidTicket = new FlightTicket(1, null, 1000);

        //when

        //given
        InvalidNameException exception = Assertions.assertThrows(InvalidNameException.class, () -> {
            ticketManager.addTicket(invalidTicket);
        });

        assertEquals("티켓 이름 올바르지 않음", exception.getMessage());
    }

}
