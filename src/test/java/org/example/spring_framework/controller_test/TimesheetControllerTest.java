package org.example.spring_framework.controller_test;

import org.example.spring_framework.homework3.project.Project;
import org.example.spring_framework.homework3.project.ProjectRepository;
import org.example.spring_framework.homework3.timesheet.Timesheet;
import org.example.spring_framework.homework3.timesheet.TimesheetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestClient;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TimesheetControllerTest {

    @Autowired
    TimesheetRepository timesheetRepository;

    @Autowired
    ProjectRepository projectRepository;

    @LocalServerPort
    private int port;
    private RestClient restClient;

    @BeforeEach
    void beforeEach() {
        restClient = RestClient.create("http://localhost:" + port);
    }

    @Test
    void getById() {
        Timesheet timesheet = new Timesheet();
        timesheet.setProjectId(2L);
        Timesheet expected = timesheetRepository.save(timesheet);

        ResponseEntity<Timesheet> actual = restClient.get()
                .uri("/timesheets/" + expected.getId())
                .retrieve()
                .toEntity(Timesheet.class);

        Timesheet responseBody = actual.getBody();
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertNotNull(responseBody);
        assertEquals(timesheet.getId(), responseBody.getId());
        assertEquals(timesheet.getProjectId(), responseBody.getProjectId());
    }

    @Test
    void getByAll() {
        Timesheet timesheet1 = new Timesheet();
        timesheet1.setProjectId(1L);
        Timesheet timesheet2 = new Timesheet();
        timesheet2.setProjectId(3L);
        timesheetRepository.save(timesheet1);
        timesheetRepository.save(timesheet2);


        ResponseEntity<List<Timesheet>> actual = restClient.get()
                .uri("/timesheets")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<Timesheet>>() {
                });

        assertNotNull(actual);
        List<Timesheet> responseBody = actual.getBody();
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertNotNull(responseBody);
        assertEquals(responseBody.size(),timesheetRepository.findAll().size());
    }

    @Test
    void testCreate() {
        Project project = new Project();
        project.setName("newProject");
        projectRepository.save(project);
        Timesheet createTimesheet = new Timesheet();
        createTimesheet.setProjectId(project.getId());

        ResponseEntity<Timesheet> response = restClient.post()
                .uri("/timesheets")
                .body(createTimesheet)
                .retrieve()
                .toEntity(Timesheet.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Timesheet responseBody = response.getBody();
        assertNotNull(responseBody);
        assertNotNull(responseBody.getId());
        assertEquals(responseBody.getProjectId(), createTimesheet.getProjectId());

        assertTrue(timesheetRepository.existsById(responseBody.getId()));
    }

    @Test
    void testDelete() {
        Timesheet deleteTimesheet = new Timesheet();
        deleteTimesheet.setProjectId(2L);
        deleteTimesheet = timesheetRepository.save(deleteTimesheet);

        ResponseEntity<Void> response = restClient.delete()
                .uri("/timesheets/" + deleteTimesheet.getId())
                .retrieve()
                .toBodilessEntity(); // less
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        assertFalse(projectRepository.existsById(deleteTimesheet.getId()));
    }
}
