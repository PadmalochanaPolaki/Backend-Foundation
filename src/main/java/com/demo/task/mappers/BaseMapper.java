package com.demo.task.mappers;

import java.util.List;

public interface BaseMapper<E,D> {
    D toDto(E entity);
    E toEntity(D dto);
    List<D> toDTOList(List<E> entityList);
}
