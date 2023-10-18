package com.example.diplom3.repository;

import com.example.diplom3.model.TaskSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSetRepository extends JpaRepository<TaskSet,Long> {
}