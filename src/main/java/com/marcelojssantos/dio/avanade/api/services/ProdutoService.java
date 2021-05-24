package com.marcelojssantos.dio.avanade.api.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.marcelojssantos.dio.avanade.api.models.Produto;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    public List<Produto> findAll(){
        return geraListaProdutos();
    }

    public void insert(Produto produto){
        System.out.println(">>> INSERIDO: " + produto);
    }

    public void update(Produto produto){
        System.out.println(">>> ATUALIZADO: " + produto);
    }

    public void delete(Long id){
        System.out.println(">>> DELETADO: " + id);
    }

    public Produto geraProduto(int id, String ean){
        return new Produto(id, "Produto " + id, new Date(), ean, false);
    }

    private List<Produto> geraListaProdutos(){
        List<Produto> listaProduto = new ArrayList<Produto>();
        Produto p1 = geraProduto(1, "0123456789");
        Produto p2 = geraProduto(2, "9876543210");
        listaProduto.add(p1);
        listaProduto.add(p2);
        return listaProduto;
    }
}