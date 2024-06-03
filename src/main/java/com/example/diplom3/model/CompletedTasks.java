package com.example.diplom3.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CompletedTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taskId")
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseProgress courseProgress;
}
