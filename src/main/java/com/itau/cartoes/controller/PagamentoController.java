package com.itau.cartoes.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.itau.cartoes.dto.PagamentoMapper;
import com.itau.cartoes.dto.request.PagamentoRequest;
import com.itau.cartoes.dto.response.PagamentoResponse;
import com.itau.cartoes.dto.response.PagamentoSummaryInListResponse;
import com.itau.cartoes.models.Pagamento;
import com.itau.cartoes.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	PagamentoService pagamentoService;
	
	@Autowired
	PagamentoMapper pagamentoMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PagamentoResponse criarPagamento(@RequestBody PagamentoRequest pagamentoRequest) {
		Pagamento pagamento = pagamentoMapper.toPagamento(pagamentoRequest);
		pagamento = pagamentoService.criarPagamento(pagamento);

		return pagamentoMapper.toPagamentoResponse(pagamento);
	}

	@GetMapping("/{cartaoid}")
	public List<PagamentoSummaryInListResponse> listByCartaoId(@PathVariable int cartaoid) {
        List<Pagamento> pagamentos = pagamentoService.listPagamentoByCartaoId(cartaoid);
        List<PagamentoSummaryInListResponse> pagamentoSummaryInListResponseList = pagamentos.stream()
                .map(pagamento -> pagamentoMapper.toPagamentoSummaryInListResponse(pagamento))
                .collect(Collectors.toList());
        return pagamentoSummaryInListResponseList;
    }

}