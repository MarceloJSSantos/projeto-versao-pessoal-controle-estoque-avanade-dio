package com.marcelojssantos.dio.avanade.api.services;

import java.util.Optional;

import com.marcelojssantos.dio.avanade.api.models.Loja;
import com.marcelojssantos.dio.avanade.api.repository.LojaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;
    
    public Iterable<Loja> findAll(){
        return lojaRepository.findAll();
    }

    public void insert(Loja loja){
        lojaRepository.save(loja);
        System.out.println(">>> INSERIDO: " + loja);
    }

    public void update(Loja loja){
        lojaRepository.save(loja);
        System.out.println(">>> ATUALIZADO: " + loja);
    }

    public void delete(Integer id){
        Optional<Loja> loja = lojaRepository.findById(id);
        if (loja.isPresent()){
            lojaRepository.delete(loja.get());
            System.out.println(">>> DELETADO: " + id);
        } else {
            System.out.println(">>> NÃO DELETADO: " + id + "- ESSE ID NÃO FOI ENCONTRADO!");
        }   
    }
}