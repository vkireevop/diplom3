package com.example.diplom3.service.models;

import com.example.diplom3.dto.TaskDto;
import com.example.diplom3.model.Task;
import com.example.diplom3.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository rep;
    public TaskServiceImpl (TaskRepository rep) {
        this.rep = rep;
    }

    @Override
    @Transactional
    public void save(Task task) {
    rep.save(task);
    }

    @Override
    @Transactional
    public void update(Long id,Task taskUpdated) {
        Task task = rep.findById(id).get();
        task.setTaskSet(taskUpdated.getTaskSet());
        task.setQuestion(taskUpdated.getQuestion());
        task.setAnswer(task.getAnswer());
    }

    @Override
    @Transactional
    public TaskDto findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(rep.findById(id).get(), TaskDto.class);
    }
}
