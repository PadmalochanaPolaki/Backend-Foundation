package com.demo.task.service;


import com.demo.task.entity.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateTaskById(Long id, Task task);
    Task patchUpdateTaskById(Long id, Task task);
    String deleteTaskById(Long id);
}
