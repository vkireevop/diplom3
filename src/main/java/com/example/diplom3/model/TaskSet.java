package com.example.diplom3.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "tasks")
@Table(name = "task_sets")
public class TaskSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_set_id")
    private Long taskSetId;

    private String title;
    private String description;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "taskSet")
    private List<Task> tasks;
}

