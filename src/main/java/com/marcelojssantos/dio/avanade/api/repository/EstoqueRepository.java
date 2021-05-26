package com.marcelojssantos.dio.avanade.api.repository;

import java.util.Optional;

import com.marcelojssantos.dio.avanade.api.models.Estoque;
import com.marcelojssantos.dio.avanade.api.models.Loja;
import com.marcelojssantos.dio.avanade.api.models.Produto;

import org.springframework.data.repository.CrudRepository;

public interface EstoqueRepository extends CrudRepository<Estoque, Integer>{
    public Optional<Estoque> findByCodigoProdutoAndCodigoLoja(Produto codigoProduto, Loja codigoLoja);
}
