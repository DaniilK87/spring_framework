package org.example.spring_framework.homework4.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring_framework.homework4.dto.ProjectPageDto;
import org.example.spring_framework.homework4.service.ProjectPageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home/projects")
public class ProjectPageController {

    private final ProjectPageService service;

    @GetMapping("/{id}")
    public String getProjectPage(@PathVariable Long id, Model model) {
        Optional<ProjectPageDto> projectOpt = service.getById(id);
        if (projectOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        model.addAttribute("project", projectOpt.get());
        return "project-page.html";
    }
}
