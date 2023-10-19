package com.example.diplom3.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = "courseProgressList")
public class StudentDto {
    private Long studentId;
    private String firstName;
    private String lastname;
    private String parentName;
    private String parentEmail;
    private String parentPhone;
    private List<CourseProgressDto> courseProgressList;
}
