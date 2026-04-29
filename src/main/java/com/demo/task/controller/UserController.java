package com.demo.task.controller;

import com.demo.task.dto.UserRequestDTO;
import com.demo.task.dto.UserResponseDTO;
import com.demo.task.response.ApiResponse;
import com.demo.task.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@Valid @RequestBody UserRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(userService.createUser(requestDTO),
                "User created successfully!"));
    }
}
