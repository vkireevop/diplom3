package com.example.diplom3.service.models;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.model.Course;
import com.example.diplom3.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
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
    @Transactional
    public void update(Long id, Course courseUpdated) {
        Course course = rep.findById(id).get();
        course.setDescription(courseUpdated.getDescription());
        course.setTitle(courseUpdated.getTitle());
        course.setAgeGroup(courseUpdated.getAgeGroup());
        course.setTaskSets(courseUpdated.getTaskSets());
    }

    @Override
    @Transactional
    public CourseDto findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(rep.findById(id).get(), CourseDto.class);
    }
    @Override
    public List<CourseDto> findAll(){
        ModelMapper mapper = new ModelMapper();
        List<Course> courses = rep.findAll().stream().toList();
        List<CourseDto> courseDto = new ArrayList<>();
        for (Course course: courses) {
            courseDto.add(mapper.map(course,CourseDto.class));
        }
        return courseDto;
    }
}
