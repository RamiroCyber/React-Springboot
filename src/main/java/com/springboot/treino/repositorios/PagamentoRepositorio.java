package com.springboot.treino.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.treino.domain.Pagamento;

@Repository
public interface PagamentoRepositorio extends JpaRepository<Pagamento, Long> {

}
