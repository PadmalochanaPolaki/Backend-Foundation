package com.project.task.service;

import com.project.task.dto.TaskRequestDto;
import com.project.task.dto.TaskResponseDto;
import com.project.task.entity.Task;

import java.util.List;

public interface TaskService {
    TaskResponseDto createTask(TaskRequestDto taskRequestDto);
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto updateTask(String taskId, TaskRequestDto taskRequestDto);
    String deleteTaskById(String taskId);
}
