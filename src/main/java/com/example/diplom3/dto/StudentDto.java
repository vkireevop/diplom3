package com.example.diplom3.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Schema(description = "Объект студента")
@ToString(exclude = "courseProgressList")
public class StudentDto {
    @Schema(description = "ИД")
    private Long studentId;
    @Schema(description = "Имя студента")
    private String firstName;
    @Schema(description = "Фамилия")
    private String lastname;
    private List<CourseProgressDto> courseProgressList;
}
