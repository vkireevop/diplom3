package com.example.diplom3.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "courseProgressList")
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    private String firstName;
    private String lastName;
    private String parentName;
    private String parentEmail;
    private String parentPhone;

    @OneToMany(mappedBy = "student")
    private List<CourseProgress> courseProgressList;
}
