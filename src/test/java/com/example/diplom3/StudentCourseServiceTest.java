package com.example.diplom3;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.example.diplom3.model.Course;
import com.example.diplom3.model.Student;
import com.example.diplom3.model.User;
import com.example.diplom3.repository.CourseProgressRepository;
import com.example.diplom3.repository.CourseRepository;
import com.example.diplom3.repository.StudentRepository;
import com.example.diplom3.security.UserService;
import com.example.diplom3.service.buisness.StudentCourseServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentCourseServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private CourseProgressRepository courseProgressRepository;

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private StudentCourseServiceImpl studentCourseService;

    private User testUser;
    private Student testStudent;
    private Course testCourse;

    @Before
    public void setUp() {
        // Инициализация тестовых данных
        testUser = new User();
        testUser.setId(1L);

        testStudent = new Student();
        testStudent.setId(1L);
        testStudent.setUser(testUser);

        testCourse = new Course();
        testCourse.setCourseId(1L);

        // Моки для методов репозиториев и сервиса
        when(userService.getCurrentUser()).thenReturn(testUser);
        when(studentRepository.getStudentByUserId(testUser.getId())).thenReturn(testStudent);
        when(courseRepository.findById(1L)).thenReturn(Optional.of(testCourse));
    }

    @Test
    public void testAddStudentAtCourse() {
        // Вызов метода, который мы тестируем
        studentCourseService.addStudentAtCourse(1L);

        // Проверка, что методы репозитория были вызваны с правильными аргументами
        verify(studentRepository).getStudentByUserId(testUser.getId());
        verify(courseRepository).findById(1L);
        verify(courseProgressRepository).save(any());
    }
}