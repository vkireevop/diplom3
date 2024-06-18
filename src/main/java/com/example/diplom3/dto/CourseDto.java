package com.example.diplom3.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Schema(description = "Объект курса")
public class CourseDto {
    @Schema(description = "ИД")
    private Long id;
    @Schema(description = "Название курса")
    private String title;
    @Schema(description = "Описание курса")
    private String description;
    @Schema(description = "Возрастная группа курса")
    private Long ageGroup;
    @Schema(description = "Список задач курса")
    private List<TaskDto> taskSets;
}
