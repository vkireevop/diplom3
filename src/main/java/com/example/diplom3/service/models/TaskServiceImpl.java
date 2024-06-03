package com.example.diplom3.service.models;

import com.example.diplom3.dto.QuestionAndOptions;
import com.example.diplom3.dto.TaskDto;
import com.example.diplom3.model.Task;
import com.example.diplom3.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository rep;
    @Override
    @Transactional
    public void save(Task task) {
    rep.save(task);
    }

    @Override
    @Transactional
    public List<TaskDto> getAll(Long courseId) {
        ModelMapper mapper = new ModelMapper();
        List<Task> tasks = rep.findAllByCourseId(courseId);
        List<TaskDto> taskDtoList = new ArrayList<>();
        for (Task t: tasks) {
            taskDtoList.add(mapper.map(t,TaskDto.class));
        }
        return taskDtoList;
    }
    private QuestionAndOptions parseQuestion(String input) {
        String question = input.substring(0, input.indexOf('?')).trim();
        String optionsString = input.substring(input.indexOf('?') + 1).trim();
        List<String> options = Arrays.asList(optionsString.split(", "));
        return new QuestionAndOptions(question, options);
    }

    @Override
    @Transactional
    public TaskDto findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(rep.findById(id).get(), TaskDto.class);
    }
}
