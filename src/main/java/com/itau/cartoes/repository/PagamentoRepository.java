package com.itau.cartoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itau.cartoes.models.Pagamento;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer>{

	 List<Pagamento> findAllByCartao_Id(Integer id);
	 
}
