package com.project.task.controller;

import com.project.task.dto.TaskRequestDto;
import com.project.task.dto.TaskResponseDto;
import com.project.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/createTask")
   public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto taskRequestDto){
        return ResponseEntity.ok(taskService.createTask(taskRequestDto));
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<TaskResponseDto>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PutMapping("/updateTask/{taskId}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable String taskId, @RequestBody TaskRequestDto taskRequestDto){
        return ResponseEntity.ok(taskService.updateTask(taskId,taskRequestDto));
    }

    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable String taskId){
        return ResponseEntity.ok(taskService.deleteTaskById(taskId));
    }
}
