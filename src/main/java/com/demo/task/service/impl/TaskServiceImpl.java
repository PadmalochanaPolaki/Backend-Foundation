package com.demo.task.service.impl;

import com.demo.task.dto.FieldErrorDto;
import com.demo.task.dto.TaskRequestDTO;
import com.demo.task.dto.TaskResponseDTO;
import com.demo.task.entity.Task;
import com.demo.task.exception.InvalidRequestException;
import com.demo.task.exception.TaskNotFoundException;
import com.demo.task.mappers.TaskMapper;
import com.demo.task.repository.TaskRepo;
import com.demo.task.service.TaskService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final TaskMapper taskMapper;

    TaskServiceImpl(TaskMapper taskMapper,TaskRepo taskRepo){
        this.taskRepo = taskRepo;
        this.taskMapper = taskMapper;
    }

    public void handleValidateMapRequest(TaskRequestDTO dto) {
        if (dto.getTaskDueDate() != null
                && dto.getTaskDueDate().isBefore(LocalDate.now())) {
            throw new InvalidRequestException(
                    "Invalid due date '" + dto.getTaskDueDate()
                            + "', due date cannot be in the past"
            );
        }
    }

    public void handleValidateCreateRequest(TaskRequestDTO dto) {
        handleValidateMapRequest(dto);  // common rules first

        if (taskRepo.existsByTaskName(dto.getTaskName())) {
            throw new InvalidRequestException(
                    "Task with name '" + dto.getTaskName() + "' already exists"
            );
        }
    }

    public void handleValidateUpdateRequest(TaskRequestDTO dto, Long id) {
        handleValidateMapRequest(dto);  // common rules first

        if (taskRepo.existsByTaskNameAndTaskIdNot(dto.getTaskName(), id)) {
            throw new InvalidRequestException(
                    "Task with name '" + dto.getTaskName() + "' already exists"
            );
        }
    }
    @Override
    public TaskResponseDTO createTask(TaskRequestDTO dto) throws BadRequestException {
        handleValidateCreateRequest(dto);

        // Convert DTO to entity — do NOT set createdAt or updatedAt here
        Task task = taskMapper.toEntity(dto);

        // JPA + AuditingEntityListener sets createdAt and updatedAt HERE
        Task savedTask = taskRepo.save(task);

        // Map saved entity (now has audit values) to response
        return taskMapper.toDTO(savedTask);
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        return taskMapper.toDTOList(taskRepo.findAll());
    }
    @Override
    public TaskResponseDTO getTaskById(Long id) throws BadRequestException {
        Task task = taskRepo.findById(id).orElseThrow(() -> new BadRequestException(
                "Task not found with id: " + id
        ));
        return taskMapper.toDTO(task);
    }

    @Override
    public TaskResponseDTO updateTaskById(Long id, TaskRequestDTO task)  {
        handleValidateUpdateRequest(task,id);
        Task existingTask = taskRepo.findById(id).orElseThrow( () -> new TaskNotFoundException(id));

        existingTask.setTaskName(task.getTaskName());
        existingTask.setTaskPriority(task.getTaskPriority());
        existingTask.setTaskStatus(task.getTaskStatus());
        existingTask.setTaskDescription(task.getTaskDescription());
        existingTask.setTaskDueDate(task.getTaskDueDate());
        Task savedTask = taskRepo.save(existingTask);

        return taskMapper.toDTO(savedTask);
    }

    @Override
    public void deleteTaskById(Long id)  {
        if (!taskRepo.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepo.deleteById(id);
    }
}
