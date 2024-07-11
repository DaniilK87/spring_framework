package org.example.spring_framework.homework4.dto;

import lombok.Data;

/**
 * ВАЖНО!
 * Перед выполнением ДЗ предполагается, что ДЗ №3 выполнено (т.е. в проекте есть сущность Project).
 * Если это не реализовано - нужно сначала завершить ДЗ №3.
 *
 * 1. Сделать страницу project-page.html по аналогии с timesheet-page.html
 * 2. В timesheets-page в колонку "Проекты" добавить ссылку на проект
 * Для этого необходимо:
 * 2.1 в TimesheetPageDto добавить поле projectId (для создания ссылки)
 * 2.2 в timesheets-page в колонку "проекты" сделать гиперссылку (по аналогии с колонкой "перейти")
 */
@Data
public class TimesheetPageDto {

  private String projectName;
  private String id;
  private String projectId;
  private String minutes;
  private String createdAt;

}
