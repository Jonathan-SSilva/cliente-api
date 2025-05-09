package com.facens.cliente_api.dto;

import lombok.Getter;
import java.util.Arrays;
import java.util.List;

@Getter
public class ApiErrorDTO {
    private List<String> errors;

    public ApiErrorDTO(String mensagem) {
        this.errors = Arrays.asList(mensagem);
    }
}