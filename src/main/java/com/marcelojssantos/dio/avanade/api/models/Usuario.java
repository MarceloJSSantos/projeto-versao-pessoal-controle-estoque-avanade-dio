package com.marcelojssantos.dio.avanade.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "usuarios")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    @Id
    @Column(name = "username", length = 50, nullable=false)
    private String userName;
    @Column(length = 60, nullable=false)
    private String senha;
    @Column(name = "primeiro_nome", length = 50, nullable=false)
    private String primeiroNome;
    @Column(name = "ultimo_nome", length = 50, nullable=false)
    private String ultimoNome;
    @Column(length = 200, nullable=true)
    private String email;
}