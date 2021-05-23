package com.marcelojssantos.dio.avanade.api.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.marcelojssantos.dio.avanade.api.models.Estoque;
import com.marcelojssantos.dio.avanade.api.models.Loja;
import com.marcelojssantos.dio.avanade.api.models.Produto;

import org.springframework.stereotype.Service;

@Service
public class EstoqueService {
    public List<Estoque> findAll(){
        Produto p1 = new Produto(1, "Produto 1", new Date(), "0123456789", true);
        Produto p2 = new Produto(2, "Produto 2", new Date(), "9876543210", false);

        Loja l1 = new Loja(1, "Loja 1", false);
        Loja l2 = new Loja(2, "Loja 2", false);
        
        List<Estoque> listaEstoque = new ArrayList<Estoque>();
        Estoque e1 = new Estoque(p1, l2, 25);
        Estoque e2 = new Estoque(p2, l1, 15);
        listaEstoque.add(e1);
        listaEstoque.add(e2);
        return listaEstoque;
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
}
