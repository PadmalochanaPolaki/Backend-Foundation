package com.demo.task.entity;

import com.demo.task.enums.Priority;
import com.demo.task.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TASK")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // FIXED: was AUTO
    @Column(name = "TLS_TASK_ID")
    private Long id;

    @Column(name = "TLS_TASK_NAME")
    private String name;

    @Column(name = "TLS_TASK_DESC")
    private String description;

    @Column(name = "TLS_TASK_PRIORITY")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "TLS_TASK_STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "TLS_TASK_DUE_DATE")
    private LocalDate dueDate;

    @CreatedDate
    @Column(name = "TLS_CREATED_DATE", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "TLS_UPDATED_DATE", nullable = false)
    private LocalDateTime updatedAt;
}