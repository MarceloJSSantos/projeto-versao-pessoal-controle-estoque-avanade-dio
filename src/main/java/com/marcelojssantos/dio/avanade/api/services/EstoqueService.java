package com.marcelojssantos.dio.avanade.api.services;

import java.util.Optional;

import com.marcelojssantos.dio.avanade.api.models.Estoque;
import com.marcelojssantos.dio.avanade.api.models.Loja;
import com.marcelojssantos.dio.avanade.api.models.Produto;
import com.marcelojssantos.dio.avanade.api.repository.EstoqueRepository;
import com.marcelojssantos.dio.avanade.api.repository.LojaRepository;
import com.marcelojssantos.dio.avanade.api.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private LojaRepository lojaRepository;
    @Autowired
    private EstoqueRepository estoqueRepository;

    public Iterable<Estoque> findAll(){
        return estoqueRepository.findAll();
    }

    public void insert(Estoque estoque){
        estoqueRepository.save(estoque);
        System.out.println(">>> INSERIDO: " + estoque);
    }

    public void update(Estoque estoque){
        estoqueRepository.save(estoque);
        System.out.println(">>> ATUALIZADO: " + estoque);
    }

    public void delete(Integer idProduto, Integer idLoja){
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        Optional<Loja> loja = lojaRepository.findById(idLoja);

        if (produto.isPresent() && loja.isPresent()){
            Optional<Estoque> estoque = estoqueRepository.findByCodigoProdutoAndCodigoLoja(produto.get(), loja.get());
            estoqueRepository.delete(estoque.get());
            System.out.println(">>> DELETADO: " + idProduto + " - " + idLoja);
        } else {
            System.out.println(">>> NÃO DELETADO: " + idProduto + " - " + idLoja + " - PELO MENOS UM DESSES IDs NÃO FOI ENCONTRADO!");
        }
    }
}
