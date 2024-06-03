package com.example.diplom3.service.facade;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.service.buisness.StudentCourseService;
import com.example.diplom3.service.models.CourseService;
import com.example.diplom3.service.models.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseFacade {
    private final CourseService courseService;
    private final StudentCourseService studentCourseService;
    private final TaskService taskService;

    public List<CourseDto> getAllCourseByAge(Long age) {
        return courseService.findAllByAge(age);
    }
    public List<CourseDto> getAllCourse() {
        return courseService.findAll();
    }

    public void followCourse(Long courseId) {
        studentCourseService.addStudentAtCourse(courseId);
    }

    public CourseDto getCourse(Long id) {
        CourseDto courseDto = courseService.findById(id);
        courseDto.setTaskSets(taskService.getAll(id) );

        return courseDto;
    }
}
