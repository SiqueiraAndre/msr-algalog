package com.algaworks.algalog.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Data
public class Problema {

    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;

    private List<Campo> campos;

    @AllArgsConstructor
    @Getter
    public static class Campo {

        private final String nome;
        private final String mensagem;

    }
}