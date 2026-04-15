package com.evento.organizacao.evento.entity;

import lombok.Data;

@Data
public class Endereco {
    private String rua;
    private String numero;
    private String cidade;
    private String uf;
}
