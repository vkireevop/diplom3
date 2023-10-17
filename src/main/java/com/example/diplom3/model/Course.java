package com.example.diplom3.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
    @Table(name = "courses")
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "course_id")
        private Long courseId;

        private String title;
        private String description;
        private String ageGroup;

        @OneToMany(mappedBy = "course")
        private List<TaskSet> taskSets;
}


