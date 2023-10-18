package com.example.diplom3.service.models;

import com.example.diplom3.dto.CourseProgressDto;
import com.example.diplom3.model.CourseProgress;

public interface CourseProgressService {
    void save(CourseProgress courseProgress);
    CourseProgressDto findById(Long id);
    void update(Long id, CourseProgress courseProgress);
}
