package com.example.diplom3.service.models;

import com.example.diplom3.dto.TaskDto;
import com.example.diplom3.model.Task;

import java.util.List;

public interface TaskService {
    void save(Task task);
    TaskDto findById(Long id);
    List<TaskDto> getAll(Long courseId);
}
