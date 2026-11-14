package com.project.task.dto;

import com.project.task.enums.Priority;
import com.project.task.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
    private String taskName;
    private String taskDescription;
    private Status taskStatus;
    private Priority taskPriority;
}
