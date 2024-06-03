package com.example.diplom3.repository;

import com.example.diplom3.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value = """
            FROM Task t
            WHERE t.course.id = :courseId
            """)
    List<Task> findAllByCourseId(@Param("courseId") Long courseId);
}
