package com.project.task.entity;

import com.project.task.enums.Priority;
import com.project.task.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "task_id", length = 36)
    private String taskId;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "task_description", columnDefinition = "TEXT")
    private String taskDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status", columnDefinition = "TEXT")
    private Status taskStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_priority", columnDefinition = "TEXT")
    private Priority taskPriority;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}