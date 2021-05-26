package com.marcelojssantos.dio.avanade.api.models;

import java.io.Serializable;

import lombok.Getter;

public class EstoqueId implements Serializable{
    @Getter
    private Integer codigoProduto;
    @Getter
    private Integer codigoLoja;
}
