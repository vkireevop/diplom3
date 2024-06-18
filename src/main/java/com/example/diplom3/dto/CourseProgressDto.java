package com.example.diplom3.dto;

import com.example.diplom3.model.Student;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Schema(description = "Объект прогресс курса")
public class CourseProgressDto {
    @Schema(description = "ИД")
    private Long progressId;
    @Schema(description = "Объект студента")
    private StudentDto student;
    @Schema(description = "Объект курса")
    private CourseDto course;
    @Schema(description = "Список выполненных задач")
    private List<TaskDto> completedTask;

}
