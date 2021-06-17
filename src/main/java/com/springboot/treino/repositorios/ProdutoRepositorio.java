package com.springboot.treino.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.treino.domain.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
