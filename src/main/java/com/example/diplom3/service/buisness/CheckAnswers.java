package com.example.diplom3.service.buisness;

import com.example.diplom3.model.Student;
import com.example.diplom3.model.Task;

public interface CheckAnswers {
    boolean checkAnswer (Task task , String answer);
    void markTaskCompleted (Long taskId,Long courseProgressId);
}
