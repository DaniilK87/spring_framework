package org.example.spring_framework.homework3.timesheet;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {
    private final TimesheetService service;

    public TimesheetController(TimesheetService service) {
        this.service = service;
    }

    // /timesheets/{id}
    @GetMapping("/{id}") // получить все
    public ResponseEntity<Timesheet> get(@PathVariable Long id) {
        Optional<Timesheet> ts = service.getById(id);

        if (ts.isPresent()) {
//      return ResponseEntity.ok().body(ts.get());
            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping // получить все
    public ResponseEntity<List<Timesheet>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping // создание нового ресурса
    public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheet) {
        timesheet = service.create(timesheet);

        // 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        // 204 No Content
        return ResponseEntity.noContent().build();
    }

}
