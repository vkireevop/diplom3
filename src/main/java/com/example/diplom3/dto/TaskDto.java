package com.example.diplom3.dto;

import com.example.diplom3.model.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
@Schema(description = "Объект задачи")
public class TaskDto {
    @Schema(description = "ИД")
    private Long taskId;
    @Schema(description = "Вопрос")
    private String question;
    @Schema(description = "Ответ")
    private String answer;
    @JsonIgnore
    private Course course;
}
