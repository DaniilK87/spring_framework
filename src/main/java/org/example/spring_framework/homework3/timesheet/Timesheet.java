package org.example.spring_framework.homework3.timesheet;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "timesheet")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;
    private Long projectId;
    private Long employeeId;
    private int minutes;
    private LocalDate createdAt;
}
