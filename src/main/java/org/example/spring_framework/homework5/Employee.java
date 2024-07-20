package org.example.spring_framework.homework5;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 1. Создать класс Employee - Сотрудник с полями
 * 1.1 Идентификтаор
 * 1.2 Имя (и фамилия)
 * 1.3 ...
 * 1.4 Создать контроллер-сервис-репозиторий для этой сущности
 *
 * 2. В timesheet добавить поле employee типа Employee (или employeeId тип Long)
 * 3. Создать ресурс /employees/{id}/timesheets - получить все таймшиты по сотруднику
 *
 * 4. ** Связываем Project <-> Employee отношением ManyToMany
 * 4.1 Т.е. на проекте может быть несколько сотрдников; один сотрудник может быть на нескольких проектах.
 */

@Data
@Entity
@Schema(description = "Описание сотрудника")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    @Schema(name = "Employee id", description = "Идентификатор сотрудника", example = "1")
    private Long id;

    @Schema(name = "Employee name", description = "Имя сотрудника", example = "Employee name #1")
    private String name;

    @Schema(name = "Employee surname", description = "Фамилия сотрудника", example = "Employee surname #1")
    private String surname;
}
