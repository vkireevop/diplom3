package com.example.diplom3.service.models;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.dto.CourseProgressDto;
import com.example.diplom3.dto.StudentDto;
import com.example.diplom3.dto.TaskDto;
import com.example.diplom3.model.CourseProgress;
import com.example.diplom3.model.Task;
import com.example.diplom3.repository.CourseProgressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CourseProgressServiceImpl implements CourseProgressService{
    private final CourseProgressRepository rep;
    public CourseProgressServiceImpl(CourseProgressRepository rep) {
        this.rep = rep;
    }

    @Override
    @Transactional
    public void save(CourseProgress courseProgress) {
        rep.save(courseProgress);
    }

}
