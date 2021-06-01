package com.marcelojssantos.dio.avanade.api.services;

import java.util.Optional;

import com.marcelojssantos.dio.avanade.api.models.Usuario;
import com.marcelojssantos.dio.avanade.api.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Iterable<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody Usuario usuario){
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
    }

    public void update(Usuario usuario){
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        System.out.println(">>> ATUALIZADO: " + usuario);
    }

    public void delete(String username){
        Optional<Usuario> usuario = usuarioRepository.findById(username);
        if (usuario.isPresent()){
            usuarioRepository.delete(usuario.get());
            System.out.println(">>> DELETADO: " + username);
        } else {
            System.out.println(">>> NÃO DELETADO: " + username + "- ESSE ID NÃO FOI ENCONTRADO!");
        }   
    }
}