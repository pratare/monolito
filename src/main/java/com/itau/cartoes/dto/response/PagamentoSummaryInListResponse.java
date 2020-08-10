package com.itau.cartoes.dto.response;

import java.math.BigDecimal;

public class PagamentoSummaryInListResponse {

	private Integer id;

	private Integer cartaoId;

    private String descricao;

    private BigDecimal valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getCartaoId() {
		return cartaoId;
	}

	public void setCartaoId(Integer cartaoId) {
		this.cartaoId = cartaoId;
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
