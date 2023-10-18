package com.example.diplom3.service.models;

import com.example.diplom3.dto.StudentDto;
import com.example.diplom3.model.Course;
import com.example.diplom3.model.Student;

public interface StudentService {
    void save(Student student);
    StudentDto findById(Long id);
    void update(Long id, Student student);
}
