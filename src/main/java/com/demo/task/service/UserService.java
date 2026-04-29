package com.demo.task.service;

import com.demo.task.dto.UserRequestDTO;
import com.demo.task.dto.UserResponseDTO;
import jakarta.validation.Valid;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO requestDTO);
}
