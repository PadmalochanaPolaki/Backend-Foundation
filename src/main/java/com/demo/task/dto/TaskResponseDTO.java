package com.demo.task.dto;


import com.demo.task.enums.Priority;
import com.demo.task.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponseDTO {
    private Long taskRid;
    private String taskName;
    private Priority taskPriority;
    private Status taskStatus;
    private String taskDescription;
    private LocalDate taskDueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
