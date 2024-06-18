package com.example.diplom3.controller;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.service.facade.TaskFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/tasks")
public class TaskController {

    private final TaskFacade taskFacade;

    @Operation(summary = "Проверка ответа на вопрос")
    @ApiResponse(responseCode = "200", description = "Проверка прошла успешно")
    @ApiResponse(responseCode = "400", description = "Указаны некорректные параметры")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @PostMapping("/checkAnswer")
    public Boolean getCourse(@RequestParam Long taskId, @RequestParam String answer) {return taskFacade.checkAnswers(taskId, answer); }
}
