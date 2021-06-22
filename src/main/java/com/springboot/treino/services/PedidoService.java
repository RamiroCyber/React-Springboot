package com.springboot.treino.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.treino.domain.Pedido;
import com.springboot.treino.repositorios.PedidoRepositorio;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepositorio pedidoRepositorio;

	public List<Pedido> buscarTodos() {
		List<Pedido> lista = pedidoRepositorio.findAll();
		return lista;
	}

	public Pedido buscarPorId(Long id) {
		Optional<Pedido> obj = pedidoRepositorio.findById(id);
		return obj.get();
	}
}
