package org.example.spring_framework.homework4.service;

import lombok.RequiredArgsConstructor;
import org.example.spring_framework.homework3.project.Project;
import org.example.spring_framework.homework3.project.ProjectRepository;
import org.example.spring_framework.homework4.dto.ProjectPageDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectPageService {

    private final ProjectRepository projectRepository;

    public Optional<ProjectPageDto> getById(Long id) {
        Project project = projectRepository.getById(id).orElseThrow();
        ProjectPageDto projectPageDto = new ProjectPageDto();
        projectPageDto.setId(String.valueOf(project.getId()));
        projectPageDto.setProjectName(project.getName());
        return Optional.of(projectPageDto);
    }
}
