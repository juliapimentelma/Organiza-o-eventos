package com.evento.organizacao.evento.service;

import com.evento.organizacao.evento.entity.Evento;
import com.evento.organizacao.evento.entity.Inscricao;
import com.evento.organizacao.evento.entity.StatusInscricao;
import com.evento.organizacao.evento.entity.Usuario;
import com.evento.organizacao.evento.repository.EventoRepository;
import com.evento.organizacao.evento.repository.InscricaoRepository;
import com.evento.organizacao.evento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Inscricao realizarInscricao(String usuarioId, String eventoId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado."));

        if (inscricaoRepository.existsByUsuarioIdAndEventoId(usuarioId, eventoId)) {
            throw new IllegalArgumentException("Usuário já está inscrito neste evento.");
        }

        long totalInscritos = inscricaoRepository.countByEventoId(eventoId);
        if (totalInscritos >= evento.getCapacidadeMaxima()) {
            throw new IllegalStateException("Desculpe, os ingressos para este evento estão esgotados.");
        }

        Inscricao novaInscricao = new Inscricao();
        novaInscricao.setUsuarioId(usuario.getId());
        novaInscricao.setEventoId(evento.getId());
        novaInscricao.setDataCompra(LocalDateTime.now());
        novaInscricao.setStatus(StatusInscricao.PAGA);

        return inscricaoRepository.save(novaInscricao);
    }

    public List<Inscricao> buscarInscricoesDoUsuario(String usuarioId) {
        return inscricaoRepository.findByUsuarioId(usuarioId);
    }

    public void cancelarInscricao(String inscricaoId) {
        Inscricao inscricao = inscricaoRepository.findById(inscricaoId)
                .orElseThrow(() -> new IllegalArgumentException("Inscrição não encontrada."));

        inscricao.setStatus(StatusInscricao.CANCELADA);
        inscricaoRepository.save(inscricao);
    }
}