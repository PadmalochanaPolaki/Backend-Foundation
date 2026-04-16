package com.demo.task.service.impl;

import com.demo.task.entity.Task;
import com.demo.task.repository.TaskRepo;
import com.demo.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    TaskServiceImpl(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    @Override
    public Task createTask(Task task) {
        
        return taskRepo.save(task);
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
