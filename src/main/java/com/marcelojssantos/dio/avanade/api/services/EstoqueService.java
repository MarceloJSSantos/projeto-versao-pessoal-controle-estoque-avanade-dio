package com.marcelojssantos.dio.avanade.api.services;

import java.util.ArrayList;
import java.util.List;

import com.marcelojssantos.dio.avanade.api.models.Estoque;
import com.marcelojssantos.dio.avanade.api.models.Loja;
import com.marcelojssantos.dio.avanade.api.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private LojaService lojaService;

    public List<Estoque> findAll(){
        return geraListaEstoque();
    }

    public void insert(Estoque estoque){
        System.out.println(">>> INSERIDO: " + estoque);
    }

    public void update(Estoque estoque){
        System.out.println(">>> ATUALIZADO: " + estoque);
    }

    public void delete(Long idProduto, Long idLoja){
        System.out.println(">>> DELETADO: " + idProduto + " - " + idLoja);
    }

    public Estoque geraEstoque(Produto p, Loja l, int quant){
        return new Estoque(p, l, quant);
    }

    private List<Estoque> geraListaEstoque(){
        List<Estoque> listaEstoque = new ArrayList<Estoque>();
        Estoque e1 = geraEstoque(
            produtoService.geraProduto(25,
            "00001595874"),
            lojaService.geraLoja(18), 118);
        Estoque e2 = geraEstoque(
            produtoService.geraProduto(6,
            "0999878965"),
            lojaService.geraLoja(12), 35);
        listaEstoque.add(e1);
        listaEstoque.add(e2);
        return listaEstoque;
    }
}
