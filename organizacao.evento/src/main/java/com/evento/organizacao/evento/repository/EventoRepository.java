package com.evento.organizacao.evento.repository;

import com.evento.organizacao.evento.entity.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventoRepository extends MongoRepository<Evento, String> {
    List<Evento> findByDataHoraAfter(LocalDateTime data);
    List<Evento> findByNomeContainingIgnoreCase(String nome);
}
