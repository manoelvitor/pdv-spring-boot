package com.pdv.service;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdv.model.Cliente;
import com.pdv.model.Produto;
import com.pdv.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente save(Cliente obj) {
		repository.save(obj);
		return obj;
	}

	public Cliente calcularCompra(Cliente obj) {
		Double soma = 0.0;
		if (obj.getId() != null) {
			for (Produto p : obj.getCompra()) {
				soma += p.getPreco();
			}
		}
		System.out.println(soma);
		obj.setVlCompra(soma);
		return repository.save(obj);
	}

}
