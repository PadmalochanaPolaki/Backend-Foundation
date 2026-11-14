package com.project.task.service.impl;

import com.project.task.dto.TaskRequestDto;
import com.project.task.dto.TaskResponseDto;
import com.project.task.entity.Task;
import com.project.task.mapper.TaskMapper;
import com.project.task.repositoy.TaskRepository;
import com.project.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository,TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        Task task = taskMapper.toEntity(taskRequestDto);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDTO(savedTask);
    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskMapper.toDTOList(taskRepository.findAll());
    }

    @Override
    public TaskResponseDto updateTask(String taskId, TaskRequestDto taskRequestDto) {
        Task existingTask = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("No Task Found"));
        existingTask.setTaskName(taskRequestDto.getTaskName());
        existingTask.setTaskDescription(taskRequestDto.getTaskDescription());
        existingTask.setTaskStatus(taskRequestDto.getTaskStatus());
        existingTask.setTaskPriority(taskRequestDto.getTaskPriority());
        Task savedTask = taskRepository.save(existingTask);
        return taskMapper.toDTO(savedTask);
    }

    @Override
    public String deleteTaskById(String taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new RuntimeException(taskId + " Not Found!");
        }
        String taskName = taskRepository.findById(taskId)
                .map(Task::getTaskName)
                .orElse("No task found");
        taskRepository.deleteById(taskId);
        return "Task " + taskName + " Deleted successfully";
    }
}
