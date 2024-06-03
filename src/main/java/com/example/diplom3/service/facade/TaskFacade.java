package com.example.diplom3.service.facade;

import com.example.diplom3.dto.QuestionAndOptions;
import com.example.diplom3.repository.TaskRepository;
import com.example.diplom3.service.models.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskFacade {

    private TaskRepository taskRepository;
    private TaskService taskService;



    private QuestionAndOptions parseQuestion(String input) {
        String question = input.substring(0, input.indexOf('?')).trim();
        String optionsString = input.substring(input.indexOf('?') + 1).trim();
        List<String> options = Arrays.asList(optionsString.split(", "));
        return new QuestionAndOptions(question, options);
    }
}
