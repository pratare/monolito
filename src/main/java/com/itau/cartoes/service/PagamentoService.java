package com.itau.cartoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.models.Pagamento;
import com.itau.cartoes.repository.PagamentoRepository;

@Component
public class PagamentoService {
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	CartaoService cartaoService;
	
	public Pagamento criarPagamento(Pagamento pagamento) {
		Cartao cartao = cartaoService.buscarCartao(pagamento.getCartao().getId());
        pagamento.setCartao(cartao);

		return pagamentoRepository.save(pagamento);
		 
	}

	public List<Pagamento> listPagamentoByCartaoId(Integer id) {
        return pagamentoRepository.findAllByCartao_Id(id);
    }

	
}
