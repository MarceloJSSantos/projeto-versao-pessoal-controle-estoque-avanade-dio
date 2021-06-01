package com.marcelojssantos.dio.avanade.api.services;

import java.util.Collections;
import java.util.Optional;

import com.marcelojssantos.dio.avanade.api.dtos.UsuarioAuthDTO;
import com.marcelojssantos.dio.avanade.api.mappers.UsuarioMapper;
import com.marcelojssantos.dio.avanade.api.models.Usuario;
import com.marcelojssantos.dio.avanade.api.repository.UsuarioRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioDetalheService implements UserDetailsService {

    @Autowired
    @NonNull
    private UsuarioRepository usuarioRepository;

    @NonNull
    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findById(userName);
        UsuarioAuthDTO usuarioAuthDTO = usuarioMapper.usuarioToUsuarioAuthDTO(usuario.get());
        if (usuarioAuthDTO == null){
            throw new UsernameNotFoundException(userName);
        }

        return new User(usuarioAuthDTO.getUserName(), usuarioAuthDTO.getSenha(), Collections.emptyList());
    }
}