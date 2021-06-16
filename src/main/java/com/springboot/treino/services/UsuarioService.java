package com.springboot.treino.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.treino.domain.Usuario;
import com.springboot.treino.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public List<Usuario> buscarTodos() {
		List<Usuario> lista = usuarioRepositorio.findAll();
		return lista;
	}

	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = usuarioRepositorio.findById(id);
		return obj.orElse(null);
	}
}
