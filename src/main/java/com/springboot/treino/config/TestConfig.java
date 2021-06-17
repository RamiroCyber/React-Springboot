package com.springboot.treino.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.treino.domain.Categoria;
import com.springboot.treino.domain.Pedido;
import com.springboot.treino.domain.Usuario;
import com.springboot.treino.enuns.StatusPedido;
import com.springboot.treino.repositorios.CategoriaRepositorio;
import com.springboot.treino.repositorios.PedidoRepositorio;
import com.springboot.treino.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario user1 = new Usuario(null, "Carla Jessica", "carla@gmail.com", "8598854515", "1234");
		Usuario user2 = new Usuario(null, "David", "david@gmail.com", "8596581526", "1234");
		
		Categoria cat1 = new Categoria("Electronics"); 
		Categoria cat2 = new Categoria("Books"); 
		Categoria cat3 = new Categoria("Computers"); 
		
		Pedido o1 = new Pedido( Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO, user1); 
		Pedido o2 = new Pedido( Instant.parse("2019-07-21T03:42:10Z"),StatusPedido.PAGAMENTO_EFETUADO, user2); 
		Pedido o3 = new Pedido( Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.AGUARDANDO_PAGAMENTO ,user1); 

		
		usuarioRepositorio.saveAll(Arrays.asList(user1,user2));
		pedidoRepositorio.saveAll(Arrays.asList(o1,o2,o3));
		
		categoriaRepositorio.saveAll((Arrays.asList(cat1,cat2,cat3)));
		
	}
}
