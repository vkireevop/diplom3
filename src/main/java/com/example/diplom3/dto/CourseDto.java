package com.example.diplom3.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private String ageGroup;
    private TaskSetDto taskSets;
}
