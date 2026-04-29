package com.demo.task.dto;

import com.demo.task.enums.Priority;
import com.demo.task.enums.Status;
import jakarta.persistence.Column;
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
public class UserRequestDTO {
    @NotBlank(message = "Username is Mandatory")
    @Size(min = 6, message = "Username should be at least 6 characters long")
    private String userName;

    @NotBlank(message = "Password is Mandatory")
    @Size(min = 8, max = 16, message = "Password should be at least 6-16 characters long")
    private String password;

    @NotBlank(message = "Firstname is Mandatory")
    private String firstName;

    @NotBlank(message = "Last is Mandatory")
    private String lastName;

    @NotBlank(message = "User email is Mandatory")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    @NotNull(message = "Is Active is Mandatory")
    private Boolean active;

}
