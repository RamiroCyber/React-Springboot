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

	public Usuario inserirUser(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

	public void deletarUser(Long id) {
		usuarioRepositorio.deleteById(id);

	}

	public Usuario atuazlizar(Long id, Usuario user) {
		Usuario usuario = usuarioRepositorio.getOne(id);
		updateData(usuario,user);
		return usuarioRepositorio.save(usuario);
	}

	private void updateData(Usuario usuario, Usuario user) {
		usuario.setNome(user.getNome());
		usuario.setTelefone(user.getTelefone());
		usuario.setEmail(user.getEmail());
		
	}
}
