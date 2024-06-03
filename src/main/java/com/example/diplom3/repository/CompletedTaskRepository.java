package com.example.diplom3.repository;

import com.example.diplom3.model.CompletedTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedTaskRepository extends JpaRepository<CompletedTasks,Long> {
}
