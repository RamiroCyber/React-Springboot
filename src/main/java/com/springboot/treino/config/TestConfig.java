package com.springboot.treino.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.treino.domain.Categoria;
import com.springboot.treino.domain.ItemPedido;
import com.springboot.treino.domain.Pedido;
import com.springboot.treino.domain.Produto;
import com.springboot.treino.domain.Usuario;
import com.springboot.treino.enuns.StatusPedido;
import com.springboot.treino.repositorios.CategoriaRepositorio;
import com.springboot.treino.repositorios.ItemPedidoRepositorio;
import com.springboot.treino.repositorios.PedidoRepositorio;
import com.springboot.treino.repositorios.ProdutoRepositorio;
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
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private ItemPedidoRepositorio itemPedidoRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario user1 = new Usuario(null, "Carla Jessica", "carla@gmail.com", "8598854515", "1234");
		Usuario user2 = new Usuario(null, "David", "david@gmail.com", "8596581526", "1234");
		
		Categoria cat1 = new Categoria("Eletoronics"); 
		Categoria cat2 = new Categoria("Books"); 
		Categoria cat3 = new Categoria("Computers"); 
		
		categoriaRepositorio.saveAll((Arrays.asList(cat1,cat2,cat3)));
		
		Produto p1 = new Produto( "The Lord of the Rings", "Lorem ipsum dolor sit amet, consetoetur.", 90.5, ""); 
		Produto p2 = new Produto( "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Produto p3 = new Produto( "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Produto p4 = new Produto("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Produto p5 = new Produto("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		produtoRepositorio.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		produtoRepositorio.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		Pedido o1 = new Pedido( Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO, user1); 
		Pedido o2 = new Pedido( Instant.parse("2019-07-21T03:42:10Z"),StatusPedido.PAGAMENTO_EFETUADO, user2); 
		Pedido o3 = new Pedido( Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.AGUARDANDO_PAGAMENTO ,user1); 

		
		usuarioRepositorio.saveAll(Arrays.asList(user1,user2));
		pedidoRepositorio.saveAll(Arrays.asList(o1,o2,o3));
		
		ItemPedido ip1 = new ItemPedido(p1, o1, 2, p1.getPreco()); 
		ItemPedido ip2 = new ItemPedido(p3, o1, 1, p3.getPreco()); 
		ItemPedido ip3 = new ItemPedido(p3, o2, 2, p3.getPreco()); 
		ItemPedido ip4 = new ItemPedido(p5, o3, 2, p5.getPreco()); 
		
		itemPedidoRepositorio.saveAll(Arrays.asList(ip1,ip2,ip3,ip4));
		
	}
}
