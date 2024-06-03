package com.example.diplom3.service.buisness;

import com.example.diplom3.model.CourseProgress;
import com.example.diplom3.model.Task;
import com.example.diplom3.repository.CourseProgressRepository;
import com.example.diplom3.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CheckAnswersServiceServiceImpl implements CheckAnswersService {
    private final TaskRepository taskRepository;

    private final CourseProgressRepository courseProgressRepository;

    public CheckAnswersServiceServiceImpl(TaskRepository taskRepository, CourseProgressRepository courseProgressRepository) {
        this.taskRepository = taskRepository;
        this.courseProgressRepository = courseProgressRepository;
    }

    @Override
    public boolean checkAnswer(Long taskId, String answer) {
        if (taskRepository.findById(taskId).get().getAnswer().equals(answer.toLowerCase())) {
            markTaskCompleted(taskId, 1L);
            return true;
        }
        else{
            return false;
        }
    }

    @Transactional
    public void markTaskCompleted(Long taskId , Long courseProgressId) {
        Task task = taskRepository.findById(taskId).get();
        CourseProgress courseProgress = courseProgressRepository.findById(courseProgressId).get();
        courseProgressRepository.save(courseProgress);
    }
}
