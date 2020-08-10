package com.itau.cartoes.dto.response;

import java.math.BigDecimal;

public class PagamentoResponse {

	private Integer id;
	
	private Integer cartaoid;
	
	private String descricao;
	
	private BigDecimal valor;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
