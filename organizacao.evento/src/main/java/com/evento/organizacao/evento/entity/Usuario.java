package com.evento.organizacao.evento.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario role;
}