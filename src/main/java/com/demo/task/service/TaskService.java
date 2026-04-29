package com.demo.task.service;


import com.demo.task.dto.TaskRequestDTO;
import com.demo.task.dto.TaskResponseDTO;
import com.demo.task.entity.Task;
import com.demo.task.response.ApiResponse;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    TaskResponseDTO createTask(TaskRequestDTO taskRequestDto) throws BadRequestException;
    List<TaskResponseDTO> getAllTasks();
    TaskResponseDTO getTaskById(Long id) throws BadRequestException;
    TaskResponseDTO updateTaskById(Long id, TaskRequestDTO task);
    void deleteTaskById(Long id);
}
