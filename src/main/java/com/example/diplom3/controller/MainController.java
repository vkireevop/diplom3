package com.example.diplom3.controller;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.dto.TaskDto;
import com.example.diplom3.service.buisness.CheckAnswersService;
import com.example.diplom3.service.buisness.StudentCourseService;
import com.example.diplom3.service.models.CourseService;
import com.example.diplom3.service.models.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private final CourseService courseService;
    private final CheckAnswersService checkAnswersService;
    private final TaskService taskService;
    private final StudentCourseService studentCourseService;

    public MainController(CourseService courseService, CheckAnswersService checkAnswersService, TaskService taskService, StudentCourseService studentCourseService) {
        this.courseService = courseService;
        this.checkAnswersService = checkAnswersService;
        this.taskService = taskService;
        this.studentCourseService = studentCourseService;
    }

    @GetMapping("/taskList/{id}")
    public ResponseEntity<List<TaskDto>> getTaskList(@PathVariable("id") Long id) {
       return new ResponseEntity<>(courseService.findById(1L).getTaskSets().getTasks(), HttpStatus.OK);
    }
    @PostMapping("/checkAnswer")
    public ResponseEntity<String> checkAnswer(@RequestParam Long id, @RequestParam String answer) {
        if (!checkAnswersService.checkAnswer(id,answer)) {
            return new ResponseEntity<>("false",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("true",HttpStatus.OK);
        }
    }
    @GetMapping("/allCourse")
    public ResponseEntity<List<CourseDto>> getAllCourses(){
     return new ResponseEntity<>(courseService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/acceptCourse")
    public void acceptCourse(@RequestParam Long idCourse,@RequestParam Long idStudent) {
        studentCourseService.addStudentAtCourse(idStudent,idCourse);

    }
}
