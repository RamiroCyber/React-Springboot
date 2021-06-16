package com.springboot.treino.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.treino.entidades.Usuario;
import com.springboot.treino.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public void run(String... args) throws Exception {
		Usuario user1 = new Usuario(null, "Carla Jessica", "carla@gmail.com", "8598854515", "1234");
		Usuario user2 = new Usuario(null, "David", "david@gmail.com", "8596581526", "1234");
		
		usuarioRepositorio.saveAll(Arrays.asList(user1,user2));
		
	}
}
