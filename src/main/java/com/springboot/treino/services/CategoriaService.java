package com.springboot.treino.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.treino.domain.Categoria;
import com.springboot.treino.repositorios.CategoriaRepositorio;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	public List<Categoria> buscarTodos() {
		List<Categoria> lista = categoriaRepositorio.findAll();
		return lista;
	}

	public Categoria buscarPorId(Long id) {
		Optional<Categoria> obj = categoriaRepositorio.findById(id);
		return obj.get();
	}
}
