package com.demo.task.dto;


import com.demo.task.enums.Priority;
import com.demo.task.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskRequestDTO {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String taskName;

    @NotNull(message = "Priority is required")
    private Priority taskPriority;

    @NotNull(message = "Status is required")
    private Status taskStatus;

    @Size(max = 256,message = "Description cannot be more than 256 characters")
    private String taskDescription;
    private LocalDate taskDueDate;
}
