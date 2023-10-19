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
        ModelMapper mapper =new ModelMapper();
        CourseProgressDto courseProgressDto = new CourseProgressDto();
        CourseProgress courseProgress = rep.findById(id).get();
        courseProgressDto.setProgressId(courseProgress.getProgressId());
        courseProgressDto.setCourse(mapper.map(courseProgress.getCourse(), CourseDto.class));
        courseProgressDto.setStudent(mapper.map(courseProgress.getStudent(), StudentDto.class));
        List<TaskDto> taskDtoList = new ArrayList<>();
        for (Task task: courseProgress.getCompletedTasks()) {
            taskDtoList.add(mapper.map(task,TaskDto.class));
        }
        courseProgressDto.setCompletedTask(taskDtoList);
        return courseProgressDto;
    }
}
