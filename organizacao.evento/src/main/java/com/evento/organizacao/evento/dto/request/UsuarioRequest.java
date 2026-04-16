package com.evento.organizacao.evento.dto.request;

import com.evento.organizacao.evento.entity.TipoUsuario;
import com.evento.organizacao.evento.entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotBlank(message = "O e-mail é obrigatório.")
        @Email(message = "Formato de e-mail inválido.")
        String email,

        @NotBlank(message = "A senha não pode estar em branco.")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
        String senha,

        @NotNull(message = "O tipo de usuário (role) é obrigatório.")
        TipoUsuario role
) {
    public Usuario paraEntidade() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setRole(this.role);
        return usuario;
    }
}