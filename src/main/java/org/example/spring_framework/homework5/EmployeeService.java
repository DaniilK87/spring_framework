package org.example.spring_framework.homework5;

import lombok.RequiredArgsConstructor;
import org.example.spring_framework.homework3.timesheet.Timesheet;
import org.example.spring_framework.homework3.timesheet.TimesheetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TimesheetRepository timesheetRepository;


    public void create(Employee employee) {
            employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<Timesheet> getEmployeeTimesheets(Long employeeId) {
        List<Timesheet> timesheetList = new ArrayList<>();
        timesheetRepository.findAll().forEach(timesheet -> {
            if (Objects.equals(timesheet.getEmployeeId(), employeeId)) timesheetList.add(timesheet);
        });
        return timesheetList;
    }
}
