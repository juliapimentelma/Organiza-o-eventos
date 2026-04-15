package com.evento.organizacao.evento.service;

import com.evento.organizacao.evento.entity.Evento;
import com.evento.organizacao.evento.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    public Evento salvar(Evento evento) {
        if (evento.getDataHora() != null && evento.getDataHora().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data do evento não pode ser no passado.");
        }

        if (evento.getCapacidadeMaxima() != null && evento.getCapacidadeMaxima() <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        return eventoRepository.save(evento);
    }

    public Optional<Evento> buscarPorId(String id) {
        return eventoRepository.findById(id);
    }

    public void deletar(String id) {
        if (!eventoRepository.existsById(id)) {
            throw new IllegalArgumentException("Evento não encontrado para exclusão.");
        }
        eventoRepository.deleteById(id);
    }
}
