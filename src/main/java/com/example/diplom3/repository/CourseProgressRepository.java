package com.example.diplom3.repository;

import com.example.diplom3.model.CourseProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseProgressRepository extends JpaRepository<CourseProgress, Long> {
    @Query(value ="""
    FROM CourseProgress cp
    WHERE cp.courseId = :courseId
    AND cp.studentId = :studentId
""")
    CourseProgress findByStudentAndCourse(@Param("courseId") Long courseId, @Param("studentId") Long studentId);
}
