package com.pdv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pdv.model.Categoria;
import com.pdv.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository repository;
	
	public Page<Categoria> getAll(Pageable page) {
		return repository.findAll(page);
		
	}
	
	
}
