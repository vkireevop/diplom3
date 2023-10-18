package com.example.diplom3.service.models;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.model.Course;

public interface CourseService {
    void save(Course course);
    CourseDto findById(Long id);
    void update(Long id,Course course);
}
