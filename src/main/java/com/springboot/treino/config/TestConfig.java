package com.springboot.treino.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.treino.domain.Pedido;
import com.springboot.treino.domain.Usuario;
import com.springboot.treino.repositorios.PedidoRepositorio;
import com.springboot.treino.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario user1 = new Usuario(null, "Carla Jessica", "carla@gmail.com", "8598854515", "1234");
		Usuario user2 = new Usuario(null, "David", "david@gmail.com", "8596581526", "1234");
		
		Pedido o1 = new Pedido( Instant.parse("2019-06-20T19:53:07Z"), user1); 
		Pedido o2 = new Pedido( Instant.parse("2019-07-21T03:42:10Z"), user2); 
		Pedido o3 = new Pedido( Instant.parse("2019-07-22T15:21:22Z"), user1); 

		
		usuarioRepositorio.saveAll(Arrays.asList(user1,user2));
		pedidoRepositorio.saveAll(Arrays.asList(o1,o2,o3));
		
		
		
	}
}
