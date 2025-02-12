package org.example.spring_framework.homework4.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring_framework.homework4.service.ProjectPageService;
import org.example.spring_framework.homework4.service.TimesheetPageService;
import org.example.spring_framework.homework4.dto.TimesheetPageDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/home/timesheets")
@RequiredArgsConstructor
public class TimesheetPageController {

  private final TimesheetPageService service;
  private final ProjectPageService pageService;


  @GetMapping
  public String getAllTimesheets(Model model) {
    List<TimesheetPageDto> timesheets = service.findAll();
    model.addAttribute("timesheets", timesheets);
    return "timesheets-page.html";
  }

  // GET /home/timesheets/{id}
  @GetMapping("/{id}")
  public String getTimesheetPage(@PathVariable Long id, Model model) {
    Optional<TimesheetPageDto> timesheetOpt = service.findById(id);
    if (timesheetOpt.isEmpty()) {
      throw new NoSuchElementException();
    }

    model.addAttribute("timesheet", timesheetOpt.get());
    return "timesheet-page.html";
  }

}
