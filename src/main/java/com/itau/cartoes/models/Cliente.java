package com.itau.cartoes.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Cliente {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
	private List<Cartao> cartoes;

	public Cliente() {
		
	}
	
	public Cliente(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}
	
}
