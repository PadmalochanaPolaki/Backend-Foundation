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
    private Long id;
    private String name;
    private Priority priority;
    private Status status;
    private String description;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
