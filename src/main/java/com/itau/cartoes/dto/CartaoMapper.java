package com.itau.cartoes.dto;

import org.springframework.stereotype.Component;

import com.itau.cartoes.dto.request.CartaoRequest;
import com.itau.cartoes.dto.response.CartaoAtivoResponse;
import com.itau.cartoes.dto.response.CartaoDetalheResponse;
import com.itau.cartoes.dto.response.CartaoResponse;
import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.models.Cliente;

@Component
public class CartaoMapper {
	
	public Cartao toCartao(CartaoRequest cartaoRequest){
		Cartao cartao = new Cartao();
		cartao.setNumero(cartaoRequest.getNumero());
			
		Cliente cliente = new Cliente();
        cliente.setId(cartaoRequest.getClienteId());

        cartao.setCliente(cliente);

        return cartao;
    }
	
	public CartaoResponse toCartaoResponse(Cartao cartao) {
		CartaoResponse cartaoResponse = new CartaoResponse();
		cartaoResponse.setId(cartao.getId());
		cartaoResponse.setNumero(cartao.getNumero());
		cartaoResponse.setAtivo(false);
		cartaoResponse.setClienteId(cartao.getCliente().getId());
        return cartaoResponse;
    }
	
	public CartaoDetalheResponse toCartaoDetalheResponse(Cartao cartao) {
		CartaoDetalheResponse cartaoDetalheResponse = new CartaoDetalheResponse();
		cartaoDetalheResponse.setId(cartao.getId());
		cartaoDetalheResponse.setNumero(cartao.getNumero());
		cartaoDetalheResponse.setClienteId(cartao.getCliente().getId());
		cartaoDetalheResponse.setAtivo(cartao.getAtivo());
        return cartaoDetalheResponse;
    }
	
	public CartaoAtivoResponse toCartaoAtivoResponse(Cartao cartao) {
        CartaoAtivoResponse cartaoAtivoResponse = new CartaoAtivoResponse();

        cartaoAtivoResponse.setId(cartao.getId());
        cartaoAtivoResponse.setNumero(cartao.getNumero());
        cartaoAtivoResponse.setClienteId(cartao.getCliente().getId());
        cartaoAtivoResponse.setAtivo(cartao.getAtivo());

        return cartaoAtivoResponse;
    }


}
