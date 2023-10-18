package com.example.diplom3.service.models;

import com.example.diplom3.dto.TaskSetDto;
import com.example.diplom3.model.Course;
import com.example.diplom3.model.TaskSet;

public interface TaskSetService {
    void save(TaskSet taskSet);
    TaskSetDto findById(Long id);
    void update(Long id,TaskSet taskSet);
}
