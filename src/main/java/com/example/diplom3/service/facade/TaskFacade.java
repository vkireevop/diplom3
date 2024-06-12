package com.example.diplom3.service.facade;

import com.example.diplom3.dto.QuestionAndOptions;
import com.example.diplom3.dto.TaskDto;
import com.example.diplom3.repository.TaskRepository;
import com.example.diplom3.service.buisness.CheckAnswersService;
import com.example.diplom3.service.models.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskFacade {
    private CheckAnswersService checkAnswersService;

    public Boolean checkAnswers(Long taskId, String answer) {
        return checkAnswersService.checkAnswer(taskId, answer);
    }
}
