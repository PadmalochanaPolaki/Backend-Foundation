package com.demo.task.exception;


import com.demo.task.dto.FieldErrorDto;
import com.demo.task.response.ApiError;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(
            MethodArgumentNotValidException ex) {

        List<FieldErrorDto> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> new FieldErrorDto(
                        e.getField(),
                        e.getDefaultMessage()
                ))
                .toList();

        return ResponseEntity
                .badRequest()
                .body(ApiError.validationError(errors));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleMalformedJson(
            HttpMessageNotReadableException ex) {

        Throwable cause = ex.getCause();

        if (cause instanceof InvalidFormatException invalidFormat) {

            String fieldName = invalidFormat.getPath().get(0).getFieldName();
            String invalidValue = invalidFormat.getValue().toString();

            // ── Enum validation ──────────────────────────────
            if (invalidFormat.getTargetType().isEnum()) {

                String validValues = Arrays.stream(
                                invalidFormat.getTargetType().getEnumConstants())
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));

                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ApiError.of(
                                "Invalid " + fieldName
                                        + " '" + invalidValue
                                        + "', must be one of: ["
                                        + validValues + "]", 400));
            }

            // ── Date validation ──────────────────────────────
            if (invalidFormat.getTargetType() == LocalDate.class
                    || invalidFormat.getTargetType() == LocalDateTime.class) {

                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ApiError.of(
                                "Invalid date '" + invalidValue
                                        + "' for field '" + fieldName
                                        + "', must be in format: yyyy-MM-dd", 400));
            }

        }

        // ── Fallback ─────────────────────────────────────────
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.of("Malformed or unreadable JSON request body", 400));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(
            BadRequestException ex) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.of(ex.getMessage(), 400));
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiError> handleTaskNotFound(
            TaskNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(ex.getMessage(), 404));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiError.of("Something went wrong", 500));
    }
}
