package com.demo.task.entity;

import com.demo.task.enums.Priority;
import com.demo.task.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TASK")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name ="TLS_TASK_DUE_DATE" )
    private LocalDate dueDate;
}
