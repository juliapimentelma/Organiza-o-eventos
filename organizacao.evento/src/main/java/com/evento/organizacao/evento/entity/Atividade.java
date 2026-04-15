package com.evento.organizacao.evento.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Atividade {
    private String titulo;
    private LocalDateTime horario;
}