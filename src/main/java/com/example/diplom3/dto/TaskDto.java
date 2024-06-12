package com.example.diplom3.dto;

import com.example.diplom3.model.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;


@Data
public class TaskDto {
    private Long taskId;
    private String question;
    private String answer;
    @JsonIgnore
    private Course course;
}
