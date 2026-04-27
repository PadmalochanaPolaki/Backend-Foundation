package com.demo.task.service.impl;

import com.demo.task.dto.TaskRequestDTO;
import com.demo.task.dto.TaskResponseDTO;
import com.demo.task.entity.Task;
import com.demo.task.mappers.TaskMapper;
import com.demo.task.repository.TaskRepo;
import com.demo.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final TaskMapper taskMapper;

    TaskServiceImpl(TaskMapper taskMapper,TaskRepo taskRepo){
        this.taskRepo = taskRepo;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO dto) {

        // Convert DTO to entity — do NOT set createdAt or updatedAt here
        Task task = taskMapper.toEntity(dto);

        // JPA + AuditingEntityListener sets createdAt and updatedAt HERE
        Task savedTask = taskRepo.save(task);

        // Map saved entity (now has audit values) to response
        return taskMapper.toDTO(savedTask);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }
    @Override
    public Task getTaskById(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    @Override
    public Task updateTaskById(Long id, Task task) {
        Task existingTask = taskRepo.findById(id).orElseThrow( () -> new RuntimeException("Please provide a valid id"));

        existingTask.setName(task.getName());
        existingTask.setDescription(task.getDescription());

        return taskRepo.save(existingTask);
    }

    @Override
    public Task patchUpdateTaskById(Long id, Task task) {
        Task existingTask = taskRepo.findById(id).orElseThrow(()-> new RuntimeException("Please provide a valid id"));

        existingTask.setName(task.getName());
        existingTask.setDescription(task.getDescription());
        return taskRepo.save(existingTask);
    }

    @Override
    public String deleteTaskById(Long id) {
         taskRepo.deleteById(id);
         return "Task deleted Successfully";
    }
}
