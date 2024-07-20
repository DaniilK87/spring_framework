package org.example.spring_framework.homework3.project;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
@Tag(name = "Projects", description = "API для работы с проектами")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Get project", description = "Получить проект по его id")
    @GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable @Parameter(description = "Идентификатор проекта") Long id) {
        Optional<Project> ts = projectService.getById(id);

        if (ts.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Get all project", description = "Получить список всех проектов")
    @GetMapping
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @Operation(summary = "Create project", description = "Создать проект")
    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project) {
        project = projectService.create(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @Operation(summary = "Delete project", description = "Удалить проект")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Parameter(description = "Идентификатор проекта") Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
