package com.evento.organizacao.evento.dto.request;

import jakarta.validation.constraints.NotBlank;

public record InscricaoRequest(

        @NotBlank(message = "O ID do usuário é obrigatório.")
        String usuarioId,

        @NotBlank(message = "O ID do evento é obrigatório.")
        String eventoId
) {
}