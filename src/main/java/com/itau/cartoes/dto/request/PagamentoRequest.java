package com.itau.cartoes.dto.request;

import java.math.BigDecimal;

public class PagamentoRequest {
	
	private Integer cartaoid;
	
	private String descricao;
	
	private BigDecimal valor;

	public Integer getCartaoid() {
		return cartaoid;
	}

	public void setCartaoid(Integer cartaoid) {
		this.cartaoid = cartaoid;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
