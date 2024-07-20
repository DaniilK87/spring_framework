package org.example.spring_framework.homework3.timesheet;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.time.LocalDate;

@Data
@Entity
@Schema(description = "Описание табеля рабочего времени")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    @Schema(name = "Timesheet id", description = "Идентификатор табеля", example = "1")
    private Long id;
    @Schema(name = "Project id", description = "Идентификатор проекта", example = "1")
    private Long projectId;
    @Schema(name = "Employee id", description = "Идентификатор сотрудника", example = "1")
    private Long employeeId;
    @Schema(name = "Timesheet minutes", description = "Время затраченное на проект", example = "100")
    private int minutes;
    @Schema(name = "Timesheet createdAt", description = "Дата создания табеля", example = "2001-01-01")
    private LocalDate createdAt;
}
