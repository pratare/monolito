package com.itau.cartoes.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itau.cartoes.exception.CartaoNotFoundException;
import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.repository.CartaoRepository;

@Component
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;


    public Cartao mostrarCartao(String numero) {
    	Optional<Cartao> cartaoOptional = cartaoRepository.getByNumero(numero);

        if(!cartaoOptional.isPresent()) {
            throw new CartaoNotFoundException();
        }

        return cartaoOptional.get();

    }

    public Cartao criarCartao(Cartao cartao) {
    	cartao = cartaoRepository.save(cartao);
    	
        return cartao;
    }

    public Cartao ativar(String numero, boolean ativo) {
    	
    	Cartao cartao = mostrarCartao(numero);
        cartao.setAtivo(ativo);
    	
        return cartaoRepository.save(cartao);
    }
    
    public Cartao buscarCartao(Integer id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);

        if(!cartaoOptional.isPresent()) {
            throw new CartaoNotFoundException();
        }

        return cartaoOptional.get();
    }


}
