package com.crudback_mauro.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErroResposta {

    private LocalDateTime timestamp;
    private int status;
    private String mensagem;
    private String caminho;
}
