package com.example.diplom3.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = "taskSets")
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private String ageGroup;
    @JsonIgnore
    private TaskSetDto taskSets;
}
