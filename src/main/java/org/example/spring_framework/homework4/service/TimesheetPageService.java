package org.example.spring_framework.homework4.service;

import lombok.RequiredArgsConstructor;
import org.example.spring_framework.homework3.project.Project;
import org.example.spring_framework.homework3.project.ProjectService;
import org.example.spring_framework.homework3.timesheet.Timesheet;
import org.example.spring_framework.homework3.timesheet.TimesheetService;
import org.example.spring_framework.homework4.dto.TimesheetPageDto;
import org.springframework.stereotype.Service;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimesheetPageService {

  private final TimesheetService timesheetService;
  private final ProjectService projectService;

  public List<TimesheetPageDto> findAll() {
    return timesheetService.getAll().stream()
      .map(this::convert)
      .collect(Collectors.toList());
  }

  public Optional<TimesheetPageDto> findById(Long id) {
    return timesheetService.getById(id) // Optional<Timesheet>
      .map(this::convert);
  }

  private TimesheetPageDto convert(Timesheet timesheet) {
    Project project = projectService.getById(timesheet.getProjectId())
      .orElseThrow();

    TimesheetPageDto timesheetPageParameters = new TimesheetPageDto();
    timesheetPageParameters.setProjectName(project.getName());
    timesheetPageParameters.setId(String.valueOf(timesheet.getId()));
    timesheetPageParameters.setProjectId(String.valueOf(project.getId()));
    timesheetPageParameters.setMinutes(String.valueOf(timesheet.getMinutes()));
    timesheetPageParameters.setCreatedAt(timesheet.getCreatedAt().format(DateTimeFormatter.ISO_DATE));

    return timesheetPageParameters;
  }

}
