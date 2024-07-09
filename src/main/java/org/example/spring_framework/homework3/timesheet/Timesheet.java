package org.example.spring_framework.homework3.timesheet;

import lombok.Data;
import org.example.spring_framework.homework3.project.Project;

import java.time.LocalDate;

@Data
public class Timesheet {
    private Long id;
    private Long projectId;
    private int minutes;
    private LocalDate createdAt;
}
