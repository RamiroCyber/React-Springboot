package com.springboot.treino.enuns;

public enum StatusPedido {
	AGUARDANDO_PAGAMENTO(1, "Aguardando Pagamento"), 
	PAGAMENTO_EFETUADO(2, "Pagamento Efetuado"), 
	CANCELADO(3, "Cancelado");

	private Integer cod;
	private String msg;

	private StatusPedido(Integer cod, String msg) {
		this.cod = cod;
		this.msg = msg;
	}

	public Integer getCod() {
		return cod;
	}

	public String getMsg() {
		return msg;
	}

	public static StatusPedido retornoPedido(Integer cod) {
		for (StatusPedido x : StatusPedido.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		return null;
	}
}
