package com.example.diplom3.util;

import com.example.diplom3.dto.CourseProgressDto;
import com.example.diplom3.model.*;
import com.example.diplom3.repository.CompletedTaskRepository;
import com.example.diplom3.service.buisness.CheckAnswersService;
import com.example.diplom3.service.models.*;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final CourseProgressService cps;
    private final CourseService cs;
    private final StudentService ss;
    private final TaskService ts;

    private final CompletedTaskRepository ctr;

    private final CheckAnswersService ca;
    @PostConstruct
    public void initialize() {

    }
}
