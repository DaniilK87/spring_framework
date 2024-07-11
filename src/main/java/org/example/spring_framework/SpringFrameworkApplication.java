package org.example.spring_framework;

import org.example.spring_framework.homework2.ScoreBoard;
import org.example.spring_framework.homework2.Ticket;
import org.example.spring_framework.homework2.TicketNumberGenerator;
import org.example.spring_framework.homework3.project.Project;
import org.example.spring_framework.homework3.project.ProjectRepository;
import org.example.spring_framework.homework3.timesheet.Timesheet;
import org.example.spring_framework.homework3.timesheet.TimesheetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class SpringFrameworkApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringFrameworkApplication.class, args);
        ProjectRepository projectRepo = ctx.getBean(ProjectRepository.class);
        for (int i = 1; i <= 5; i++) {
            Project project = new Project();
            project.setId((long) i);
            project.setName("Project #" + i);
            projectRepo.create(project);
        }

        TimesheetRepository timesheetRepo = ctx.getBean(TimesheetRepository.class);

        LocalDate createdAt = LocalDate.now();
        for (int i = 1; i <= 10; i++) {
            createdAt = createdAt.plusDays(1);

            Timesheet timesheet = new Timesheet();
            timesheet.setId((long) i);
            timesheet.setProjectId(ThreadLocalRandom.current().nextLong(1, 6));
            timesheet.setCreatedAt(createdAt);
            timesheet.setMinutes(ThreadLocalRandom.current().nextInt(100, 1000));

            timesheetRepo.create(timesheet);
        }
    }

//        SpringApplication.run(SpringFrameworkApplication.class, args);

//        ConfigurableApplicationContext context = SpringApplication.run(SpringFrameworkApplication.class, args);
//
//
//        ScoreBoard scoreBoard = context.getBean(ScoreBoard.class);
//        Ticket ticket = scoreBoard.newTicket();
//        System.out.println(ticket);
}


