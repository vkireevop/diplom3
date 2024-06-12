package com.example.diplom3.service.buisness;

import com.example.diplom3.model.CompletedTasks;
import com.example.diplom3.model.CourseProgress;
import com.example.diplom3.model.Student;
import com.example.diplom3.model.Task;
import com.example.diplom3.repository.CompletedTaskRepository;
import com.example.diplom3.repository.CourseProgressRepository;
import com.example.diplom3.repository.StudentRepository;
import com.example.diplom3.repository.TaskRepository;
import com.example.diplom3.security.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CheckAnswersServiceServiceImpl implements CheckAnswersService {
    private final TaskRepository taskRepository;
    private final CompletedTaskRepository ctr;
    private final StudentRepository sr;
    private final UserService us;
    private final CourseProgressRepository courseProgressRepository;

    @Override
    public boolean checkAnswer(Long taskId, String answer) {
        Task task = taskRepository.findById(taskId).get();
        if (task.getAnswer().equals(answer)) {
            markTaskCompleted(task);
            return true;
        }
        else{
            return false;
        }
    }

    @Transactional
    public void markTaskCompleted(Task  task) {
        Student student = sr.getStudentByUserId(us.getCurrentUser().getId());
        CourseProgress courseProgress = courseProgressRepository.findByStudentAndCourse(task.getCourse().getCourseId(),student.getId());
        CompletedTasks completedTasks = new CompletedTasks();
        completedTasks.setTask(task);
        completedTasks.setCourseProgress(courseProgress);
        ctr.save(completedTasks);
    }
}
