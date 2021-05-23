package com.marcelojssantos.dio.avanade.api.controllers;

import java.util.List;

import com.marcelojssantos.dio.avanade.api.models.Estoque;
import com.marcelojssantos.dio.avanade.api.services.EstoqueService;

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

@RestController
@RequestMapping("/api/v1/itensEstoque")
public class EstoqueController {
    
    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<Estoque> listar(){
        return estoqueService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody Estoque estoque){
        estoqueService.insert(estoque);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody Estoque estoque){
        estoqueService.update(estoque);
    }

    @DeleteMapping
    @RequestMapping("{idProduto}/{idLoja}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Long idProduto, @PathVariable Long idLoja){
        estoqueService.delete(idProduto,idLoja);
    }
    
}
