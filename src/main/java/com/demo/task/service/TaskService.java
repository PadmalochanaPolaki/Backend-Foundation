package com.demo.task.service;


import com.demo.task.dto.TaskRequestDTO;
import com.demo.task.dto.TaskResponseDTO;
import com.demo.task.entity.Task;
import jakarta.validation.Valid;

import java.util.List;

public interface TaskService {
    TaskResponseDTO createTask(TaskRequestDTO taskRequestDto);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateTaskById(Long id, Task task);
    Task patchUpdateTaskById(Long id, Task task);
    String deleteTaskById(Long id);
}
