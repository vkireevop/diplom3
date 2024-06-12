package com.example.diplom3.controller;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.service.facade.TaskFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/tasks")
public class TaskController {

    private final TaskFacade taskFacade;
    @PostMapping("/checkAnswer")
    public Boolean getCourse(@RequestParam Long taskId, @RequestParam String answer) {return taskFacade.checkAnswers(taskId, answer); }
}
