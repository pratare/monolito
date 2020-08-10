package com.itau.cartoes.dto;

import org.springframework.stereotype.Component;

import com.itau.cartoes.dto.request.PagamentoRequest;
import com.itau.cartoes.dto.response.PagamentoResponse;
import com.itau.cartoes.dto.response.PagamentoSummaryInListResponse;
import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.models.Pagamento;

@Component
public class PagamentoMapper {
	
	public Pagamento toPagamento(PagamentoRequest pagamentoRequest) {
		Pagamento pagamento = new Pagamento();
		pagamento.setDescricao(pagamentoRequest.getDescricao());
		pagamento.setValor(pagamentoRequest.getValor());
		
		Cartao cartao = new Cartao();
		cartao.setId(pagamentoRequest.getCartaoid());
		
		pagamento.setCartao(cartao);
		
		return pagamento;
	}

	public PagamentoResponse toPagamentoResponse(Pagamento pagamento) {
		PagamentoResponse pagamentoResponse = new PagamentoResponse();
		pagamentoResponse.setCartaoid(pagamento.getCartao().getId());
		pagamentoResponse.setDescricao(pagamento.getDescricao());
		pagamentoResponse.setValor(pagamento.getValor());
		pagamentoResponse.setId(pagamento.getId());
		
		return pagamentoResponse;
		
	}
	
	public PagamentoSummaryInListResponse toPagamentoSummaryInListResponse(Pagamento pagamento) {
        PagamentoSummaryInListResponse pagamentoSummaryInListResponse = new PagamentoSummaryInListResponse();
        pagamentoSummaryInListResponse.setId(pagamento.getId());
        pagamentoSummaryInListResponse.setDescricao(pagamento.getDescricao());
        pagamentoSummaryInListResponse.setValor(pagamento.getValor());
        pagamentoSummaryInListResponse.setCartaoId(pagamento.getCartao().getId());

        return pagamentoSummaryInListResponse;
    }

	
}
