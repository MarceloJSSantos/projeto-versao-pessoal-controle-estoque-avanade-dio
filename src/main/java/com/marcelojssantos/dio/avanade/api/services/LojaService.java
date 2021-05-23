package com.marcelojssantos.dio.avanade.api.services;

import java.util.ArrayList;
import java.util.List;

import com.marcelojssantos.dio.avanade.api.models.Loja;

import org.springframework.stereotype.Service;

@Service
public class LojaService {
    public List<Loja> findAll(){
        List<Loja> listaLoja = new ArrayList<Loja>();
        Loja l1 = new Loja(1, "Loja 1", false);
        Loja l2 = new Loja(2, "Loja 2", false);
        listaLoja.add(l1);
        listaLoja.add(l2);
        return listaLoja;
    }

    public void insert(Loja loja){
        System.out.println(">>> INSERIDO: " + loja);
    }

    public void update(Loja loja){
        System.out.println(">>> ATUALIZADO: " + loja);
    }

    public void delete(Long id){
        System.out.println(">>> DELETADO: " + id);
    }
}
