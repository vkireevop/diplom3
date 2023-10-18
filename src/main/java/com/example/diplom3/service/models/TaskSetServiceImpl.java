package com.example.diplom3.service.models;

import com.example.diplom3.dto.TaskSetDto;
import com.example.diplom3.model.TaskSet;
import com.example.diplom3.repository.TaskSetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TaskSetServiceImpl implements TaskSetService {
    private final TaskSetRepository rep;
    public TaskSetServiceImpl (TaskSetRepository rep) {
        this.rep = rep;
    }

    @Override
    @Transactional
    public void save(TaskSet taskSet) {
    rep.save(taskSet);
    }

    @Override
    @Transactional
    public void update(Long id,TaskSet taskSetUpdated) {
        TaskSet taskSet = rep.findById(id).get();
        taskSet.setTasks(taskSetUpdated.getTasks());
        taskSet.setDescription(taskSet.getDescription());
        taskSet.setCourse(taskSet.getCourse());
        taskSet.setTitle(taskSet.getTitle());
    }

    @Override
    @Transactional
    public TaskSetDto findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(rep.findById(id).get(), TaskSetDto.class);
    }
}
