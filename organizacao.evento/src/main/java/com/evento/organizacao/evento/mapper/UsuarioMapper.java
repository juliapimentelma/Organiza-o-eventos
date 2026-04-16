package com.evento.organizacao.evento.mapper;

import com.evento.organizacao.evento.dto.request.UsuarioRequest;
import com.evento.organizacao.evento.dto.response.UsuarioResponse;
import com.evento.organizacao.evento.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioRequest request);
    UsuarioResponse toResponse(Usuario usuario);
}
