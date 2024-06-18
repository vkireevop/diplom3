package com.example.diplom3.controller;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.service.facade.CourseFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Получение всех курсов")
    @ApiResponse(responseCode = "200", description = "Получение курсов прошло успешно")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/getAll")
    public List<CourseDto> getAllCourses() {return courseFacade.getAllCourse();
    }

    @Operation(summary = "Получение всех курсов по возрастному фильтру")
    @ApiResponse(responseCode = "200", description = "Получение курсов прошло успешно")
    @ApiResponse(responseCode = "400", description = "Указаны некорректные параметры")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/getAllByAge/{age}")
    public List<CourseDto> getAllCoursesByAge(@PathVariable Long age) {
        return courseFacade.getAllCourseByAge(age);
    }

    @Operation(summary = "Подписаться на курс")
    @ApiResponse(responseCode = "200", description = "Подписка прошла успешно")
    @ApiResponse(responseCode = "400", description = "Указаны некорректные параметры")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @PostMapping("/followCourse/{id}")
    public void followCourse(@PathVariable String id) {
        courseFacade.followCourse(Long.valueOf(id)); }

    @Operation(summary = "Получение курса по ИД")
    @ApiResponse(responseCode = "200", description = "Получение курса прошло успешно")
    @ApiResponse(responseCode = "400", description = "Указаны некорректные параметры")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/getCourse/{id}")
    public CourseDto getCourse(@PathVariable Long id) {return courseFacade.getCourse(id); }
}
