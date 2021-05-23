package com.marcelojssantos.dio.avanade.api.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.marcelojssantos.dio.avanade.api.models.Produto;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    public List<Produto> findAll(){
        List<Produto> listaProduto = new ArrayList<Produto>();
        Produto p1 = new Produto(1, "Produto 1", new Date(), "0123456789", true);
        Produto p2 = new Produto(2, "Produto 2", new Date(), "9876543210", false);
        listaProduto.add(p1);
        listaProduto.add(p2);
        return listaProduto;
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
}
