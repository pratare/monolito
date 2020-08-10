package com.itau.cartoes.service;

import com.itau.cartoes.dto.request.ClienteRequest;
import com.itau.cartoes.exception.ClienteNotFoundException;
import com.itau.cartoes.models.Cliente;
import com.itau.cartoes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ClienteRequest clienteRequest;
	
	public Cliente buscarCliente(Integer id) {
		Optional<Cliente> user = clienteRepository.findById(id);
		if(!user.isPresent()) {
			throw new ClienteNotFoundException();
		}
		return user.get();
	}

	public Cliente cadastrar(Cliente cliente) {

		cliente = clienteRepository.save(cliente);

        return cliente;
	}

}
