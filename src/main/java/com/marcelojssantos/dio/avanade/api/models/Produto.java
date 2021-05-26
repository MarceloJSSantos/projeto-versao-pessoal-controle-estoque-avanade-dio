package com.marcelojssantos.dio.avanade.api.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="produtos")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer codigo;
    @NonNull
    private String descricao;
    @NonNull
    private LocalDate validade;
    @NonNull
    private String ean;
    @NonNull
    private Boolean inativo;

    @JsonBackReference
    @OneToMany(mappedBy = "codigoProduto")
    private List<Estoque> estoque;
}