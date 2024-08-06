package org.example.spring_framework.homework8;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * 1. В LoggingAspect добавить логирование типов и значений аргументов.
 * Например (пример вывода): TimesheetService.findById(Long = 3)
 * Эту информацию можно достать из joinPoint.getArgs()
 *
 * 2. * Создать аспект, который аспектирует методы, помеченные аннотацией Recover, и делает следующее:
 * 2.1 Если в процессе исполнения метода был exception (любой),
 * то его нужно залогировать ("Recovering TimesheetService#findById after Exception[RuntimeException.class, "exception message"]")
 * и вернуть default-значение наружу Default-значение: для примитивов значение по умолчанию, для ссылочных типов - null.
 * Для void-методов возвращать не нужно.
 *
 * 3. **** В аннотацию Recover добавить атрибут Class<?>[] noRecoverFor, в которое можно записать список классов исключений,
 * которые НЕ нужно отлавливать.
 * Это вхождение должно учитывать иерархию классов.
 *
 * Пример:
 * @Recover(noRecoverFor = {NoSuchElementException.class, IllegalStateException.class})
 * public Timesheet getById(Long id) {...}
 *
 */
//@Slf4j // Slf4j - Simple logging facade for java
//@Aspect
//@Component
public class LoggingAspect {



//    @Pointcut("execution(* org.example.spring_framework.homework3.timesheet.TimesheetService.*(..))")
//    public void timesheetServiceMethodsPointcut() {
//    }
//
//    @Before(value = "timesheetServiceMethodsPointcut()")
//    public void beforeTimesheetServiceFindAll(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//        log.info("Before -> NoArgs -> TimesheetService.{}", methodName);
//    }
//
//    @Before(value = "execution(* org.example.spring_framework.homework3.timesheet.TimesheetService.getById(..))")
//    public void beforeTimesheetServiceFindById(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//        Object type = jp.getArgs()[0].getClass();
//        String args = Arrays.toString(jp.getArgs());
//        log.info("Before -> TimesheetService.{},{},{}", methodName,type,args);
//    }
//
//    @AfterThrowing(value = "timesheetServiceMethodsPointcut()", throwing = "e")
//    public void afterTimesheetServiceCreate(JoinPoint jp, Exception e) {
//        String methodName = jp.getSignature().getName();
//        log.info("AfterThrowing -> TimesheetService.{} -> {}", methodName,e.getClass().getName());
//    }
//
//    @After(value = "execution(* org.example.spring_framework.homework3.timesheet.TimesheetService.delete(..))")
//    public void afterTimesheetServiceDelete(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//        Object type = jp.getArgs()[0].getClass();
//        String args = Arrays.toString(jp.getArgs());
//        log.info("After -> TimesheetService.{},{},{}", methodName,type,args);
//    }
}
