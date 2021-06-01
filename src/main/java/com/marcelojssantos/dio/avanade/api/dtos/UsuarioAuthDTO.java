package com.marcelojssantos.dio.avanade.api.dtos;

import java.io.Serializable;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAuthDTO implements Serializable{
    private String userName;
    private String senha;
}
