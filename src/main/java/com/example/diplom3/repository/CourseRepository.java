package com.example.diplom3.repository;

import com.example.diplom3.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query(value = """
    FROM Course c
    WHERE c.ageGroup = :age
""")
    List<Course> findAllByAgeGroup(@Param("age") Long age);
}
