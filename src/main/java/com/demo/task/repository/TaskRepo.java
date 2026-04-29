package com.demo.task.repository;

import com.demo.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
     boolean existsByTaskName(String taskName);
     boolean existsByTaskNameAndTaskIdNot(String taskName, Long id);
}
