package com.evento.organizacao.evento.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "inscricoes")
public class Inscricao {

    @Id
    private String id;

    private String usuarioId;
    private String eventoId;

    private LocalDateTime dataCompra;
    private StatusInscricao status;
}