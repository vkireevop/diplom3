package com.example.diplom3.controller;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.service.facade.CourseFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/courses")
public class CourseController {
    private CourseFacade courseFacade;

    @GetMapping("/getAll")
    public List<CourseDto> getAllCourses() {return courseFacade.getAllCourse();
    }

    @GetMapping("/getAllByAge/{age}")
    public List<CourseDto> getAllCoursesByAge(@PathVariable Long age) {
        return courseFacade.getAllCourseByAge(age);
    }

    @PostMapping("/followCourse/{id}")
    public void followCourse(@PathVariable String id) {
        courseFacade.followCourse(Long.valueOf(id)); }

    @GetMapping("/getCourse/{id}")
    public CourseDto getCourse(@PathVariable Long id) {return courseFacade.getCourse(id); }
}
