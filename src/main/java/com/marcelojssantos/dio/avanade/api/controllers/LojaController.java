package com.marcelojssantos.dio.avanade.api.controllers;

import com.marcelojssantos.dio.avanade.api.models.Loja;
import com.marcelojssantos.dio.avanade.api.services.LojaService;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lojas")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @GetMapping
    public Iterable<Loja> listar(){
        return lojaService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody Loja loja){
        lojaService.insert(loja);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody Loja loja){
        lojaService.update(loja);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Integer id){
        lojaService.delete(id);
    }   
}