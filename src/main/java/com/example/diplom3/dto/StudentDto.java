package com.example.diplom3.dto;

import com.example.diplom3.model.CourseProgress;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private Long studentId;
    private String firstName;
    private String lastname;
    private String parentName;
    private String parentEmail;
    private String parentPhone;
    private List<CourseProgress> courseProgressList;
}
