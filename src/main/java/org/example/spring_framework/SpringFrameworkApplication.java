package org.example.spring_framework;

import org.example.spring_framework.homework2.ScoreBoard;
import org.example.spring_framework.homework2.Ticket;
import org.example.spring_framework.homework2.TicketNumberGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringFrameworkApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringFrameworkApplication.class, args);

//        ConfigurableApplicationContext context = SpringApplication.run(SpringFrameworkApplication.class, args);
//
//
//        ScoreBoard scoreBoard = context.getBean(ScoreBoard.class);
//        Ticket ticket = scoreBoard.newTicket();
//        System.out.println(ticket);
    }

}
