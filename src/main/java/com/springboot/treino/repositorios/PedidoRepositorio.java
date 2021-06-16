package com.springboot.treino.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.treino.domain.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}
