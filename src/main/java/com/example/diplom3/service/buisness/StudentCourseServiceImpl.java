package com.example.diplom3.service.buisness;

import com.example.diplom3.model.Course;
import com.example.diplom3.model.CourseProgress;
import com.example.diplom3.model.Student;
import com.example.diplom3.repository.CourseProgressRepository;
import com.example.diplom3.repository.CourseRepository;
import com.example.diplom3.repository.StudentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentCourseServiceImpl implements StudentCourseService{
    private final StudentRepository sr;
    private final CourseProgressRepository cpr;
    private final CourseRepository cr;
    public StudentCourseServiceImpl(StudentRepository sr, CourseProgressRepository cpr, CourseRepository cr) {
        this.sr = sr;
        this.cpr = cpr;
        this.cr = cr;
    }

    @Override
    @Transactional
    public void addStudentAtCourse(Long studentId, Long courseId) {
        Student student = sr.findById(studentId).get();
        Course course = cr.findById(courseId).get();
        CourseProgress courseProgress = new CourseProgress();
        courseProgress.setStudent(student);
        courseProgress.setCourse(course);
        cpr.save(courseProgress);
    }
}
