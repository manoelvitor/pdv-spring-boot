package com.pdv.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdv.model.Categoria;
import com.pdv.repository.CategoriaRepository;
import com.pdv.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@Autowired
	private CategoriaService service;

	// localhost:8080/categorias?size=5 para paginar de 5 em 5 elementos
	// ?size=5&page=1 o ultima parametro é o numero da pagina,
	// paginação se inicia no 0
	@GetMapping
	public ResponseEntity<Page<Categoria>> getall(Pageable page) {
		return ResponseEntity.ok(service.getAll(page));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Categoria>> getall(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id));
	}

}
