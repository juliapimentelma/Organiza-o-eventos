package com.evento.organizacao.evento.dto.response;

import com.evento.organizacao.evento.entity.Usuario;

public record UsuarioResponse(
        String id,
        String nome,
        String email,
        String role
) {

    public static UsuarioResponse daEntidade(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole().name()
        );
    }
}