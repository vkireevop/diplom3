package com.example.diplom3.service.models;

import com.example.diplom3.dto.CourseProgressDto;
import com.example.diplom3.model.CourseProgress;
import com.example.diplom3.repository.CourseProgressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public void update(Long id, CourseProgress courseProgressUpdated) {
        CourseProgress courseProgress = rep.findById(id).get();
        courseProgress.setCourse(courseProgressUpdated.getCourse());
        courseProgress.setStudent(courseProgressUpdated.getStudent());
        courseProgress.setCompletedTasks(courseProgressUpdated.getCompletedTasks());
    }
    @Override
    @Transactional
    public CourseProgressDto findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(rep.findById(id).get(),CourseProgressDto.class);
    }
}
