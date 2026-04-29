package com.demo.task.service.impl;

import com.demo.task.dto.UserRequestDTO;
import com.demo.task.dto.UserResponseDTO;
import com.demo.task.entity.User;
import com.demo.task.mappers.UserMapper;
import com.demo.task.repository.UserRepository;
import com.demo.task.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepo;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepo) {
        this.userMapper = userMapper;
        this.userRepo = userRepo;
    }


    @Override
    public UserResponseDTO createUser(UserRequestDTO requestDTO) {
        User user = userMapper.toEntity(requestDTO);

        User savedUser = userRepo.save(user);

        return userMapper.toDTO(savedUser);

    }
}
