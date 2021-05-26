package com.marcelojssantos.dio.avanade.api.models;

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
@Table(name = "lojas")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer codigo;
    @NonNull
    private String nome;
    @NonNull
    private Boolean inativo;

    @JsonBackReference
    @OneToMany(mappedBy = "codigoLoja")
    private List<Estoque> estoque;
}
