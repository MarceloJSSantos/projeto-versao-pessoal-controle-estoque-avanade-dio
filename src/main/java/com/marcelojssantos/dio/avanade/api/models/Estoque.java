package com.marcelojssantos.dio.avanade.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(EstoqueId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_produto", nullable = false)
    private Produto codigoProduto;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_loja", nullable = false)
    private Loja codigoLoja;
    
    private Integer quantidade;
}