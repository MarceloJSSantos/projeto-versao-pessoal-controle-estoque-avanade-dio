package com.marcelojssantos.dio.avanade.api.services;

import java.util.Optional;

import com.marcelojssantos.dio.avanade.api.models.Produto;
import com.marcelojssantos.dio.avanade.api.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Iterable<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public void insert(Produto produto){
        produtoRepository.save(produto);
        System.out.println(">>> INSERIDO: " + produto);
    }

    public void update(Produto produto){
        produtoRepository.save(produto);
        System.out.println(">>> ATUALIZADO: " + produto);
    }

    public void delete(Integer id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            produtoRepository.delete(produto.get());
            System.out.println(">>> DELETADO: " + id);
        }else{
            System.out.println(">>> NÃO DELETADO: " + id + "- ESSE ID NÃO FOI ENCONTRADO!");
        }
    }
}