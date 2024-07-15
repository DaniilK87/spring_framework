package org.example.spring_framework.homework3.timesheet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

}
