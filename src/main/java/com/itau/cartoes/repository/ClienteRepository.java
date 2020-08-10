package com.itau.cartoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.itau.cartoes.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
