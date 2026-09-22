package com.liz.api_alunos.exception;

import java.time.Instant;

public record ErroResponse(
        int status,
        String menssagem,
        Instant timestamp
) {
}
