package com.evento.organizacao.evento.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "eventos")
public class Evento {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private Integer capacidadeMaxima;
    private Endereco endereco;
    private List<Atividade> cronograma;
}