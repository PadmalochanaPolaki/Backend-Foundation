package com.demo.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "TLS_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TLS_USER_ID")
    private Long userId;

    @Column(name = "TLS_USERNAME", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "TLS_EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "TLS_PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name = "TLS_FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "TLS_LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "TLS_PHONE_NUMBER", length = 20)
    private String phoneNumber;

    @Column(name = "TLS_IS_ACTIVE")
    private Boolean active;             // ← renamed from isActive

    @CreatedDate                        // ← added
    @Column(name = "TLS_CREATED_AT", updatable = false)
    private LocalDate createdAt;

    @LastModifiedDate                   // ← added
    @Column(name = "TLS_UPDATED_AT")
    private LocalDate updatedAt;
}
