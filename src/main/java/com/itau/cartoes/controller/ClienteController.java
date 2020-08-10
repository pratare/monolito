package com.itau.cartoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itau.cartoes.dto.ClienteMapper;
import com.itau.cartoes.dto.request.ClienteRequest;
import com.itau.cartoes.dto.response.ClienteDetalheResponse;
import com.itau.cartoes.dto.response.ClienteResponse;
import com.itau.cartoes.models.Cliente;
import com.itau.cartoes.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteMapper clienteMapper;
	
	@GetMapping("/{id}")
	public ClienteDetalheResponse exibeCliente(@PathVariable int id) {
		Cliente clienteId = clienteService.buscarCliente(id);
        return clienteMapper.toClienteDetalheResponse(clienteId);

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponse cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
		Cliente cliente = clienteMapper.toCliente(clienteRequest);
		cliente = clienteService.cadastrar(cliente);
		return clienteMapper.toClienteResponse(cliente);
	}
	
}
