package com.example.diplom3.util;

import com.example.diplom3.dto.CourseProgressDto;
import com.example.diplom3.model.*;
import com.example.diplom3.service.buisness.CheckAnswersService;
import com.example.diplom3.service.models.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final CourseProgressService cps;
    private final CourseService cs;
    private final StudentService ss;
    private final TaskService ts;
    private final TaskSetService tss;
    private final CheckAnswersService ca;
    public DataInitializer(CourseProgressService cps, CourseService cs, StudentService ss, TaskService ts, TaskSetService tss, CheckAnswersService ca) {
        this.cps = cps;
        this.cs = cs;
        this.ss = ss;
        this.ts = ts;
        this.tss = tss;
        this.ca = ca;
    }
    @PostConstruct
    public void initialize(){
        Course course = new Course();
        course.setTitle("тест курс");
        course.setDescription("тестовый");
        course.setAgeGroup("10");
        cs.save(course);
        TaskSet taskSet = new TaskSet();
        taskSet.setTitle("набор заданий1");
        taskSet.setDescription(" ");
        taskSet.setCourse(course);
        tss.save(taskSet);
        Task task = new Task();
        task.setQuestion("таск вопрос1");
        task.setAnswer("таск ответ1");
        task.setTaskSet(taskSet);
        ts.save(task);
        Task task1 = new Task();
        task1.setQuestion("таск вопрос2");
        task1.setAnswer("таск ответ12");
        task1.setTaskSet(taskSet);
        ts.save(task1);
        Student student = new Student();
        student.setFirstName("student1");
        student.setLastName("student1");
        ss.save(student);

    }
}
