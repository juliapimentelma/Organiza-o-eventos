package com.evento.organizacao.evento.controller;

import com.evento.organizacao.evento.dto.request.UsuarioRequest;
import com.evento.organizacao.evento.dto.response.UsuarioResponse;
import com.evento.organizacao.evento.entity.Usuario;
import com.evento.organizacao.evento.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public record LoginRequest(String email, String senha) {}

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponse> cadastrar(@Valid @RequestBody UsuarioRequest request) {
        Usuario novoUsuario = request.paraEntidade();
        Usuario usuarioSalvo = usuarioService.cadastrar(novoUsuario);
        UsuarioResponse response = UsuarioResponse.daEntidade(usuarioSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> login(@RequestBody LoginRequest request) {
        Usuario usuarioLogado = usuarioService.autenticar(request.email(), request.senha());
        UsuarioResponse response = UsuarioResponse.daEntidade(usuarioLogado);
        return ResponseEntity.ok(response);
    }
}