package org.example.spring_framework.homework3.timesheet;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timesheets")
@Tag(name = "Timesheets", description = "API для работы с табелем учета рабочего времени")
public class TimesheetController {
    private final TimesheetService service;

    public TimesheetController(TimesheetService service) {
        this.service = service;
    }

    @Operation(summary = "Get timesheet", description = "Получить табель по его id")
    @GetMapping("/{id}") // получить все
    public ResponseEntity<Timesheet> get(@PathVariable @Parameter(description = "Идентификатор табеля") Long id) {
        Optional<Timesheet> ts = service.getById(id);
        if (ts.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Get all timesheets", description = "Получить список табелей")
    @GetMapping
    public ResponseEntity<List<Timesheet>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Create timesheet", description = "Создать табель")
    @PostMapping
    public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheet) {
        timesheet = service.create(timesheet);
        return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
    }

    @Operation(summary = "Delete timesheet", description = "Удалить табель")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Parameter(description = "Идентификатор табеля") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
