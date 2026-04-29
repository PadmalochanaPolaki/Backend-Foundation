package com.demo.task.controller;

import com.demo.task.dto.TaskRequestDTO;
import com.demo.task.dto.TaskResponseDTO;
import com.demo.task.response.ApiResponse;
import com.demo.task.service.TaskService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ApiResponse<TaskResponseDTO>> createTask(@Valid @RequestBody TaskRequestDTO taskRequestDto) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(taskService.createTask(taskRequestDto),
                        "Task created successfully!"));
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<ApiResponse<List<TaskResponseDTO>>> getAllTasks(){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.ok(taskService.getAllTasks(),
                "Tasks fetched successfully!"));
    }

    @GetMapping("/getTaskById/{id}")
    public ResponseEntity<ApiResponse<TaskResponseDTO>> getTaskById(@PathVariable Long id) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.ok(taskService.getTaskById(id),
                "Task Fetched successfully!"));
    }

    @PutMapping("/updateTaskById/{id}")
    public ResponseEntity<ApiResponse<TaskResponseDTO>> updateTaskById(@PathVariable Long id, @Valid @RequestBody TaskRequestDTO task) {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.created(taskService.updateTaskById(id, task),
                "Task Updated successfully!"));
    }


    @DeleteMapping("/deleteTaskById/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTaskById(@PathVariable Long id)  {

        taskService.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.deleted("Task deleted successfully"));
    }
}
