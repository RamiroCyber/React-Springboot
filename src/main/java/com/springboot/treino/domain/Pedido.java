package com.springboot.treino.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.springboot.treino.enuns.StatusPedido;



@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private Integer statusPedido;

	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	public Pedido() {
	}

	public Pedido(Instant momento, StatusPedido statusPedido,  Usuario cliente) {
		super();
		this.momento = momento;
		this.statusPedido = statusPedido.getCod();
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusPedido getStatusPedido() {
		return StatusPedido.retornoPedido(statusPedido);
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido.getCod();
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Double total() {
		return null;
	}
}