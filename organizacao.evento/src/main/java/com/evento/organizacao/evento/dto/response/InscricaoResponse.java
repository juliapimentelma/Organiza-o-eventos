package com.evento.organizacao.evento.dto.response;

import com.evento.organizacao.evento.entity.Inscricao;

import java.time.LocalDateTime;

public record InscricaoResponse(
        String id,
        String usuarioId,
        String eventoId,
        LocalDateTime dataCompra,
        String status
) {
    public static InscricaoResponse daEntidade(Inscricao inscricao) {
        return new InscricaoResponse(
                inscricao.getId(),
                inscricao.getUsuarioId(),
                inscricao.getEventoId(),
                inscricao.getDataCompra(),
                inscricao.getStatus().name()
        );
    }
}