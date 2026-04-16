package com.evento.organizacao.evento.repository;

import com.evento.organizacao.evento.entity.Inscricao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricaoRepository extends MongoRepository<Inscricao, String> {

    List<Inscricao> findByUsuarioId(String usuarioId);
    List<Inscricao> findByEventoId(String eventoId);
    long countByEventoId(String eventoId);
    boolean existsByUsuarioIdAndEventoId(String usuarioId, String eventoId);
}