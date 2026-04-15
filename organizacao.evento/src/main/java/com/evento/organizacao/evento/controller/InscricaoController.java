package com.evento.organizacao.evento.controller;

import com.evento.organizacao.evento.entity.Inscricao;
import com.evento.organizacao.evento.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscricoes")
@CrossOrigin(origins = "http://localhost:4200")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    public record NovaInscricaoRequest(String usuarioId, String eventoId) {}

    @PostMapping
    public ResponseEntity<Inscricao> realizarInscricao(@RequestBody NovaInscricaoRequest request) {
        Inscricao inscricao = inscricaoService.realizarInscricao(request.usuarioId(), request.eventoId());
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Inscricao>> buscarPorUsuario(@PathVariable String usuarioId) {
        List<Inscricao> inscricoes = inscricaoService.buscarInscricoesDoUsuario(usuarioId);
        return ResponseEntity.ok(inscricoes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarInscricao(@PathVariable String id) {
        inscricaoService.cancelarInscricao(id);
        return ResponseEntity.noContent().build();
    }
}