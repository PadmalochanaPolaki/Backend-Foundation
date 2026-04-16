package com.demo.task.controller;

import com.demo.task.dto.TaskRequestDto;
import com.demo.task.entity.Task;
import com.demo.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskRequestDto dto) {
        Task task = dto.toEntity();
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/getTaskById/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @PutMapping("/updateTaskById/{id}")
    public Task updateTaskById(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTaskById(id, task);
    }

    @PatchMapping("/patchUpdateTaskById/{id}")
    public Task patchUpdateTaskById(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTaskById(id, task);
    }

    @DeleteMapping("/deleteTaskById/{id}")
    public String deleteTaskById(@PathVariable Long id){
        return taskService.deleteTaskById(id);
    }
}
