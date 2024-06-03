package com.example.diplom3.service.buisness;

import com.example.diplom3.model.Course;
import com.example.diplom3.model.CourseProgress;
import com.example.diplom3.model.Student;
import com.example.diplom3.repository.CourseProgressRepository;
import com.example.diplom3.repository.CourseRepository;
import com.example.diplom3.repository.StudentRepository;

import com.example.diplom3.security.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StudentCourseServiceImpl implements StudentCourseService{
    private final StudentRepository sr;
    private final CourseProgressRepository cpr;
    private final CourseRepository cr;

    private final UserService userService;

    @Override
    @Transactional
    public void addStudentAtCourse(Long courseId) {
        Student student = sr.getStudentByUserId(userService.getCurrentUser().getId());
        Course course = cr.findById(courseId).get();
        CourseProgress courseProgress = new CourseProgress();
        courseProgress.setStudent(student);
        courseProgress.setCourse(course);
        cpr.save(courseProgress);
    }
}
