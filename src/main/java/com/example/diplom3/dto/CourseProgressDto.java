package com.example.diplom3.dto;

import com.example.diplom3.model.Student;
import lombok.Data;

import java.util.List;

@Data
public class CourseProgressDto {
    private Long progressId;
    private StudentDto student;
    private CourseDto course;
    private List<TaskDto> completedTask;

}
