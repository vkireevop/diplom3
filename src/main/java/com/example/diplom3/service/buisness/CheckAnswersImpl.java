package com.example.diplom3.service.buisness;

import com.example.diplom3.model.CourseProgress;
import com.example.diplom3.model.Student;
import com.example.diplom3.model.Task;
import com.example.diplom3.model.TaskSet;
import com.example.diplom3.repository.CourseProgressRepository;
import com.example.diplom3.repository.StudentRepository;
import com.example.diplom3.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CheckAnswersImpl implements CheckAnswers{
    private TaskRepository taskRepository;

    private StudentRepository studentRepository;
    private CourseProgressRepository courseProgressRepository;
    @Override
    public boolean checkAnswer(Task task, String answer) {
        return task.getAnswer().equals(answer.toLowerCase());
    }
    @Override
    @Transactional
    public void markTaskCompleted(Long taskId , Long courseProgressId) {
        Task task = taskRepository.findById(taskId).get();
        CourseProgress courseProgress = courseProgressRepository.findById(courseProgressId).get();
        courseProgress.getCompletedTasks().add(task);
    }
}
