package com.evento.organizacao.evento.dto.request;

import com.evento.organizacao.evento.entity.Evento;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record EventoRequest(

        @NotBlank(message = "O nome do evento não pode ficar em branco.")
        String nome,

        @NotBlank(message = "A descrição é obrigatória.")
        String descricao,

        @NotNull(message = "A data e hora são obrigatórias.")
        @Future(message = "A data do evento deve ser no futuro.")
        LocalDateTime dataHora,

        @Positive(message = "O preço deve ser maior que zero.")
        Double precoBase,

        @NotNull(message = "A capacidade máxima é obrigatória.")
        @Positive(message = "A capacidade deve ser de pelo menos 1 pessoa.")
        Integer capacidadeMaxima

) {
    public Evento paraEntidade() {
        Evento evento = new Evento();
        evento.setNome(this.nome);
        evento.setDescricao(this.descricao);
        evento.setDataHora(this.dataHora);
        evento.setPrecoBase(this.precoBase);
        evento.setCapacidadeMaxima(this.capacidadeMaxima);
        return evento;
    }
}
