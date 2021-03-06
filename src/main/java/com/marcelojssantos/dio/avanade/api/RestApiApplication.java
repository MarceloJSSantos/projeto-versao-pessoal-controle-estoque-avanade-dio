package com.marcelojssantos.dio.avanade.api;

import com.marcelojssantos.dio.avanade.api.dtos.UsuarioAuthDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
    	return new BCryptPasswordEncoder();
	}

}