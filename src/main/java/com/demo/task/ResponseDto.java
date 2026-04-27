package com.demo.task;

import com.demo.task.dto.FieldErrorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    private boolean success;
    private T data;
    private List<FieldErrorDto> errors;

}
