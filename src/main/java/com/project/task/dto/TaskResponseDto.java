package com.project.task.dto;

import com.project.task.enums.Priority;
import com.project.task.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDto {
    private String taskId;
    private String taskName;
    private String taskDescription;
    private Priority taskPriority;
    private Status taskStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
