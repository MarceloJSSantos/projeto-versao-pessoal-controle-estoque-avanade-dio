package com.marcelojssantos.dio.avanade.api.secutity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcelojssantos.dio.avanade.api.dtos.UsuarioAuthDTO;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                               HttpServletResponse res) throws AuthenticationException{
        try{
            UsuarioAuthDTO creds = new ObjectMapper().readValue(req.getInputStream(),
                                                                UsuarioAuthDTO.class);
            return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    creds.getUserName(),
                    creds.getSenha(),
                    new ArrayList<>())
            );
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                           HttpServletResponse res,
                                           FilterChain chain,
                                           Authentication auth) throws IOException, ServletException{
        
        String token = JWT.create()
                          .withSubject(((User) auth.getPrincipal()).getUsername())
                          .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                          .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));
        
        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
    }

}