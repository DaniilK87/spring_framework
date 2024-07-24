package org.example.spring_framework;

import org.example.spring_framework.homework2.ScoreBoard;
import org.example.spring_framework.homework2.Ticket;
import org.example.spring_framework.homework2.TicketNumberGenerator;
import org.example.spring_framework.homework3.project.Project;
import org.example.spring_framework.homework3.project.ProjectRepository;
import org.example.spring_framework.homework3.timesheet.Timesheet;
import org.example.spring_framework.homework3.timesheet.TimesheetRepository;
import org.example.spring_framework.homework5.Employee;
import org.example.spring_framework.homework5.EmployeeRepository;
import org.example.spring_framework.homework7.model.Role;
import org.example.spring_framework.homework7.model.User;
import org.example.spring_framework.homework7.repo.RoleRepository;
import org.example.spring_framework.homework7.repo.UserRepository;
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


        UserRepository userRepository = ctx.getBean(UserRepository.class);
        User admin = new User();
        admin.setLogin("admin");
        admin.setPassword("$2a$12$LbAPCsHn8ZN5MUDqDmIX7e9n1YlDkCxEt0lW3Q2WuW0M1vteo8jvG"); // admin
        User user = new User();
        user.setLogin("user");
        user.setPassword("$2a$12$.dlnBAYq6sOUumn3jtG.AepxdSwGxJ8xA2iAPoCHSH61Vjl.JbIfq"); // user
        User rest = new User();
        rest.setLogin("rest");
        rest.setPassword("$2y$10$RYvMNSRTe58ZT2RvvXxcneJtmG0jYVQ.i0x0Qgf5b.zeVtOUP4X6O"); // rest
        admin = userRepository.save(admin);
        user = userRepository.save(user);
        rest = userRepository.save(rest);

        RoleRepository roleRepository = ctx.getBean(RoleRepository.class);

        Role adminRole = new Role();
        adminRole.setId(admin.getId());
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setId(user.getId());
        userRole.setName("USER");
        roleRepository.save(userRole);

        Role restRole = new Role();
        restRole.setId(rest.getId());
        restRole.setName("REST");
        roleRepository.save(restRole);


        ProjectRepository projectRepo = ctx.getBean(ProjectRepository.class);
        for (int i = 1; i <= 5; i++) {
            Project project = new Project();
            project.setId((long) i);
            project.setName("Project #" + i);
            projectRepo.save(project);
        }

        EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
        for (int i = 1; i <= 4; i++) {
            Employee employee = new Employee();
            employee.setId((long) i);
            employee.setName("Employee name #" + i);
            employee.setSurname("Employee surname #" + i);
            employeeRepository.save(employee);
        }

        TimesheetRepository timesheetRepo = ctx.getBean(TimesheetRepository.class);

        LocalDate createdAt = LocalDate.now();
        for (int i = 1; i <= 10; i++) {
            createdAt = createdAt.plusDays(1);

            Timesheet timesheet = new Timesheet();
            timesheet.setId((long) i);
            timesheet.setProjectId(ThreadLocalRandom.current().nextLong(1, 6));
            timesheet.setEmployeeId(ThreadLocalRandom.current().nextLong(6, 10));
            timesheet.setCreatedAt(createdAt);
            timesheet.setMinutes(ThreadLocalRandom.current().nextInt(100, 1000));

            timesheetRepo.save(timesheet);
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


