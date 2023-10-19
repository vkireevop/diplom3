package com.example.diplom3.service.buisness;

import com.example.diplom3.model.Task;

public interface CheckAnswersService {
    boolean checkAnswer (Long taskId , String answer);
}
