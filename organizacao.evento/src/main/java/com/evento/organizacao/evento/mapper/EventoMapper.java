package com.evento.organizacao.evento.mapper;

import com.evento.organizacao.evento.dto.request.EventoRequest;
import com.evento.organizacao.evento.dto.response.EventoResponse;
import com.evento.organizacao.evento.entity.Evento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventoMapper {
    Evento toEntity(EventoRequest request);
    EventoResponse toResponse(Evento evento);
}
