package com.example.diplom3.repository;

import com.example.diplom3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value = """
            FROM Student s
            WHERE s.user.id = :id
            """)
    Student getStudentByUserId(@Param("id") Long id);
}
