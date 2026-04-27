package com.demo.task.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private boolean success;
    private int statusCode;
    private String message;
    private List<String> errors;        // validation errors

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    // Validation errors - multiple
    public static ApiError validationError(List<String> errors) {
        return ApiError.builder()
                .success(false)
                .statusCode(400)
                .message("Validation failed")
                .errors(errors)
                .build();
    }

    // Single error - not found, unauthorized etc
    public static ApiError of(String message, int statusCode) {
        return ApiError.builder()
                .success(false)
                .statusCode(statusCode)
                .message(message)
                .build();
    }
}