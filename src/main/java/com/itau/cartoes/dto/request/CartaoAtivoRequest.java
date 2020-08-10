package com.itau.cartoes.dto.request;

import javax.validation.constraints.NotNull;

public class CartaoAtivoRequest {
	
	@NotNull
    private Boolean ativo;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
