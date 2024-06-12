package com.example.diplom3.util;

import com.example.diplom3.dto.CourseProgressDto;
import com.example.diplom3.model.*;
import com.example.diplom3.repository.CompletedTaskRepository;
import com.example.diplom3.service.buisness.CheckAnswersService;
import com.example.diplom3.service.models.*;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final CourseProgressService cps;
    private final CourseService cs;
    private final StudentService ss;
    private final TaskService ts;

    private final CompletedTaskRepository ctr;

    private final CheckAnswersService ca;
    @PostConstruct
    public void initialize() {
    Course course= new Course();
    course.setAgeGroup(10L);
    course.setTitle("Тест1");
    course.setDescription("тест1");
    cs.save(course);
    Task task = new Task();
    task.setCourse(course);
    task.setQuestion("таск1");
    task.setAnswer("таск1");
    ts.save(task);
    Course course1= new Course();
    course1.setAgeGroup(10L);
    course1.setTitle("Тест2");
    course1.setDescription("тест2");
    cs.save(course1);
    Task task1 = new Task();
    task1.setCourse(course1);
    task1.setQuestion("таск2");
    task1.setAnswer("таск2");
    ts.save(task1);
    Student student = new Student();
    student.setFirstName("vadim");
    student.setLastName("nevadim");
    ss.save(student);
    CourseProgress courseProgress = new CourseProgress();
    courseProgress.setCourse(course);
    courseProgress.setStudent(student);
    cps.save(courseProgress);
    CompletedTasks completedTasks = new CompletedTasks();
    completedTasks.setCourseProgress(courseProgress);
    completedTasks.setTask(task);
    ctr.save(completedTasks);

    }
}
