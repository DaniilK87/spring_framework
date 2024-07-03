package org.example.spring_framework.homework2;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class ScoreBoard {

    private final TicketNumberGenerator ticketNumberGenerator;

    public Ticket newTicket() {
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        LocalDateTime createdAt = LocalDateTime.now(zoneId);
        Ticket ticket = new Ticket(ticketNumberGenerator.createNewNumber(), createdAt);
        return ticket;
    }


}
