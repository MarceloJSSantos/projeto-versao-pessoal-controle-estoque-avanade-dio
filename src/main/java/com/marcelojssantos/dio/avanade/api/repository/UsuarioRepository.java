package com.marcelojssantos.dio.avanade.api.repository;

import com.marcelojssantos.dio.avanade.api.models.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
    
}