package com.evento.organizacao.evento.dto.response;

import com.evento.organizacao.evento.entity.Evento;

import java.time.LocalDateTime;

public record EventoResponse(
        String id,
        String nome,
        LocalDateTime dataHora,
        Double precoBase,
        String statusVagas
) {
    public static EventoResponse daEntidade(Evento evento, long totalInscritos) {

        String status = (totalInscritos >= evento.getCapacidadeMaxima())
                ? "ESGOTADO"
                : "VAGAS DISPONÍVEIS";

        return new EventoResponse(
                evento.getId(),
                evento.getNome(),
                evento.getDataHora(),
                evento.getPrecoBase(),
                status
        );
    }
}