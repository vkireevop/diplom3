package com.example.diplom3.service.models;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.dto.TaskDto;
import com.example.diplom3.model.Course;
import com.example.diplom3.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository rep;
    public CourseServiceImpl (CourseRepository rep) {
        this.rep = rep;
    }


    @Override
    @Transactional
    public void save(Course course) {
        rep.save(course);
    }

    @Override
    public List<CourseDto> findAllByAge(Long age){
        ModelMapper mapper = new ModelMapper();
        List<Course> courses = rep.findAllByAgeGroup(age);
        List<CourseDto> courseDto = new ArrayList<>();
        for (Course course: courses) {
            courseDto.add(mapper.map(course,CourseDto.class));
        }
        return courseDto;

    }

    @Override
    @Transactional
    public CourseDto findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Course course = rep.findById(id).get();
        return mapper.map(course, CourseDto.class);
    }
    @Override
    public List<CourseDto> findAll(){
        ModelMapper mapper = new ModelMapper();
        List<Course> courses = rep.findAll();
        List<CourseDto> courseDto = new ArrayList<>();
        for (Course course: courses) {
            courseDto.add(mapper.map(course,CourseDto.class));
        }
        return courseDto;
    }
}
