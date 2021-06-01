package com.marcelojssantos.dio.avanade.api.controllers;

import com.marcelojssantos.dio.avanade.api.models.Usuario;
import com.marcelojssantos.dio.avanade.api.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/usuarios")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping
    public Iterable<Usuario> listar(){
        return usuarioService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
        public void inserir(@RequestBody Usuario usuario){
        usuarioService.insert(usuario);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody Usuario usuario){
        usuarioService.update(usuario);
    }

    @DeleteMapping
    @RequestMapping("{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable String username){
        usuarioService.delete(username);
    }
}