package com.springboot.treino.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.treino.domain.Produto;
import com.springboot.treino.repositorios.ProdutoRepositorio;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	public List<Produto> buscarTodos() {
		List<Produto> lista = produtoRepositorio.findAll();
		return lista;
	}

	public Produto buscarPorId(Long id) {
		Optional<Produto> obj = produtoRepositorio.findById(id);
		return obj.orElse(null);
	}
}
