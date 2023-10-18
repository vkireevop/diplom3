package com.example.diplom3.dto;

import com.example.diplom3.model.Course;
import com.example.diplom3.model.Task;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class TaskSetDto {
    private Long taskSetId;

    private String title;
    private String description;
    private Course course;
    private List<TaskDto> tasks;
}
