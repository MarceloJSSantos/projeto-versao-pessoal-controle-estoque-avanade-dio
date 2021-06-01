package com.marcelojssantos.dio.avanade.api.controllers;

import com.marcelojssantos.dio.avanade.api.dtos.UsuarioAuthDTO;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AutenticacaoController {
    
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public void login(@RequestBody UsuarioAuthDTO usuarioAuthDTO){
        usuarioAuthDTO.setUserName(bCryptPasswordEncoder.encode(usuarioAuthDTO.getSenha()));
    }

}