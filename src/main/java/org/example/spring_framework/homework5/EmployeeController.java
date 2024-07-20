package org.example.spring_framework.homework5;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.spring_framework.homework3.timesheet.Timesheet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Tag(name = "Employee", description = "API для работы с сотрудниками")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Create employee", description = "Создать сотрудника")
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employeeService.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @Operation(summary = "Get all employee", description = "Получить список всех сотрудников")
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @Operation(summary = "Get all timesheets by employee", description = "Получить список всех проектов по id сотрудника")
    @GetMapping("/{id}/timesheets")
    public ResponseEntity<List<Timesheet>> getEmployeeTimesheets(@PathVariable @Parameter(description = "Идентификатор сотрудника") Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeTimesheets(id));
    }
}
