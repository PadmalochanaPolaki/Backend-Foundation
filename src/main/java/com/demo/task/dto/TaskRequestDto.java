package com.demo.task.dto;

import com.demo.task.entity.Task;
import com.demo.task.enums.Priority;
import com.demo.task.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequestDto {
    //Mandatory fields
    @NotBlank(message = "Task name is required")
    private String name;
    @NotNull(message = "Task Priority is required")
    private Priority priority;
    @NotNull(message = "Task Status is Required")
    private Status status;

    //Optional fields
    private String description;
    private LocalDate dueDate;

    public Task toEntity() {
        return Task.builder()        // uses Lombok @Builder on Task
                .name(this.name)
                .priority(this.priority)
                .status(this.status)
                .description(this.description)
                .dueDate(this.dueDate)
                .build();            // creates the Task object
    }
}
