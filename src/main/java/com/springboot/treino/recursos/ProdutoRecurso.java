package com.springboot.treino.recursos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.treino.domain.Produto;
import com.springboot.treino.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecurso {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> allProdutos() {
		List<Produto> lista = produtoService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> BuscarPorId(@PathVariable Long id) {
		Produto obj = produtoService.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
