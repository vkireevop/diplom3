package com.example.diplom3;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.diplom3.dto.CourseDto;
import com.example.diplom3.dto.TaskDto;
import com.example.diplom3.service.facade.CourseFacade;
import com.example.diplom3.service.models.CourseService;
import com.example.diplom3.service.models.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CourseFacadeTests {

    @Mock
    private CourseService courseService;

    @Mock
    private TaskService taskService;

    @InjectMocks
    private CourseFacade courseFacade;

    @Before
    public void setUp() {
        // Инициализация тестовых данных
        CourseDto courseDto1 = new CourseDto();
        courseDto1.setId(1L);
        courseDto1.setTitle("Course 1");

        CourseDto courseDto2 = new CourseDto();
        courseDto2.setId(2L);
        courseDto2.setTitle("Course 2");

        List<CourseDto> courseDtos = Arrays.asList(courseDto1, courseDto2);

        // Моки для методов сервисов
        when(courseService.findAllByAge(20L)).thenReturn(courseDtos);
        when(courseService.findAll()).thenReturn(courseDtos);
        when(courseService.findById(1L)).thenReturn(courseDto1);
        when(taskService.getAll(1L)).thenReturn(Arrays.asList(new TaskDto(), new TaskDto()));
    }

    @Test
    public void testGetAllCourseByAge() {
        List<CourseDto> courses = courseFacade.getAllCourseByAge(20L);
        assertEquals(2, courses.size());
    }

    @Test
    public void testGetAllCourse() {
        List<CourseDto> courses = courseFacade.getAllCourse();
        assertEquals(2, courses.size());
    }

    @Test
    public void testGetCourse() {
        CourseDto course = courseFacade.getCourse(1L);
        assertEquals("Course 1", course.getTitle());
        assertEquals(2, course.getTaskSets().size());
    }
}