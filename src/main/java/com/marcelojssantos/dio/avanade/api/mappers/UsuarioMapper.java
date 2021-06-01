package com.marcelojssantos.dio.avanade.api.mappers;

import com.marcelojssantos.dio.avanade.api.dtos.UsuarioAuthDTO;
import com.marcelojssantos.dio.avanade.api.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario usuarioAuthToUsuario(UsuarioAuthDTO usuarioAuthDTO);

    UsuarioAuthDTO usuarioToUsuarioAuthDTO(Usuario usuario);

}