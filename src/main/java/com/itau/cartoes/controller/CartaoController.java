package com.itau.cartoes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.itau.cartoes.dto.CartaoMapper;
import com.itau.cartoes.dto.request.CartaoAtivoRequest;
import com.itau.cartoes.dto.request.CartaoRequest;
import com.itau.cartoes.dto.response.CartaoAtivoResponse;
import com.itau.cartoes.dto.response.CartaoDetalheResponse;
import com.itau.cartoes.dto.response.CartaoResponse;
import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.service.CartaoService;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoService cartaoService;
	
	@Autowired
	private CartaoMapper cartaoMapper;
	
	@GetMapping("/{numero}")
	public CartaoDetalheResponse exibeCartao(@PathVariable String numero) {
        Cartao cartao = cartaoService.mostrarCartao(numero);
        return cartaoMapper.toCartaoDetalheResponse(cartao);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CartaoResponse cadastrarNovoCartao(@Valid @RequestBody CartaoRequest cartaoRequest){
		Cartao cartao = cartaoMapper.toCartao(cartaoRequest);
		cartao = cartaoService.criarCartao(cartao);
		return cartaoMapper.toCartaoResponse(cartao);
	}
	
	@PatchMapping("/{numero}")
    public CartaoAtivoResponse ativarCartao(@PathVariable String numero, @Valid  @RequestBody CartaoAtivoRequest cartaoAtivoRequest) {
        Cartao cartao = cartaoService.ativar(numero, cartaoAtivoRequest.getAtivo());
        return cartaoMapper.toCartaoAtivoResponse(cartao);
    }


}
