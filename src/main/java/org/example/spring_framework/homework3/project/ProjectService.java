package org.example.spring_framework.homework3.project;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Optional<Project> getById(Long id) {
        return repository.findById(id);
    }

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Project create(Project project) {
        return repository.save(project);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
