package com.marcelojssantos.dio.avanade.api.services;

import java.util.ArrayList;
import java.util.List;

import com.marcelojssantos.dio.avanade.api.models.Loja;

import org.springframework.stereotype.Service;

@Service
public class LojaService {
    public List<Loja> findAll(){
        return geraListaLojas();
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

    public Loja geraLoja(int id){
        return new Loja(id, "Loja " + id, false);
    }

    private List<Loja> geraListaLojas(){
        List<Loja> listaLoja = new ArrayList<Loja>();
        Loja l1 = geraLoja(1);
        Loja l2 = geraLoja(2);
        listaLoja.add(l1);
        listaLoja.add(l2);
        return listaLoja;
    }
}
