package com.marcelojssantos.dio.avanade.api.repository;

import com.marcelojssantos.dio.avanade.api.models.Produto;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
    
}
