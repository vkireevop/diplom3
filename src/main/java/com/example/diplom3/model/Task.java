package com.example.diplom3.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    private String question;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "task_set_id")
    private TaskSet taskSet;
}
