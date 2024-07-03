package org.example.spring_framework.homework2;


import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TicketNumberGenerator {

    public String createNewNumber() {
        String X = UUID.randomUUID().toString();
        return "Ticket #" + X;
    }


}
