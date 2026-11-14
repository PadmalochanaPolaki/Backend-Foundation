package com.project.task.mapper;

import java.util.List;

public interface  BaseMapper<ENTITY, REQ, RES> {
    RES toDTO(REQ entity);
    ENTITY toEntity(REQ dto);
    List<RES> toDTOList(List<ENTITY> entityList);
}
