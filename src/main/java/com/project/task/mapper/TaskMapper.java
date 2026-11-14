package com.project.task.mapper;

import com.project.task.dto.TaskRequestDto;
import com.project.task.dto.TaskResponseDto;
import com.project.task.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper
        extends BaseMapper<Task, TaskRequestDto, TaskResponseDto> {

    @Override
    @Mapping(target = "taskId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Task toEntity(TaskRequestDto dto);

    TaskResponseDto toDTO(Task task);
}
