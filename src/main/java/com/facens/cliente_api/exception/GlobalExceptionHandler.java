package com.facens.cliente_api.exception;

import com.facens.cliente_api.dto.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorDTO handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ApiErrorDTO(ex.getMessage());
    }
}