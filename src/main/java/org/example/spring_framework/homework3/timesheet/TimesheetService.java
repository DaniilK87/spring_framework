package org.example.spring_framework.homework3.timesheet;

import org.example.aspect.LoggingMethodNoParam;
import org.example.aspect.LoggingMethodWithParam;
import org.example.spring_framework.homework3.project.ProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class TimesheetService {
    private final TimesheetRepository repository;
    private final ProjectRepository projectRepository;

    public TimesheetService(TimesheetRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    @LoggingMethodWithParam
    public Optional<Timesheet> getById(Long id) {
        return repository.findById(id);
    }

    @LoggingMethodNoParam
    public List<Timesheet> getAll() {
        return repository.findAll();
    }

    public Timesheet create(Timesheet timesheet) {
        if (timesheet.getProjectId() == null) {
            throw new RuntimeException("projectId не может быть null");
        }

        if (projectRepository.findById(timesheet.getProjectId()).isEmpty()) {
            throw new RuntimeException("Проект с id " + timesheet.getProjectId() + " не существует");
        }
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        LocalDate localDate = LocalDate.from(LocalDateTime.now(zoneId));
        timesheet.setCreatedAt(localDate);

        return repository.save(timesheet);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
