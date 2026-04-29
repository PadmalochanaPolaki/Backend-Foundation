package com.demo.task.mappers;

import com.demo.task.dto.UserRequestDTO;
import com.demo.task.dto.UserResponseDTO;
import com.demo.task.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserResponseDTO>{

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "active", source = "active")
    User toEntity(UserRequestDTO dto);
    UserResponseDTO toDTO(User user);
}
