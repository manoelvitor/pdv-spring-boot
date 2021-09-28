package com.pdv.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdv.model.Cliente;
import com.pdv.model.Produto;
import com.pdv.repository.ProdutoRepository;
import com.pdv.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> getall() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> getall(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id));
	}

	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto obj) {
		return ResponseEntity.ok(service.save(obj));
	}

	@GetMapping("/ordenarporcategoria/{id}")
	public ResponseEntity<List<Produto>> listarPorCategoria(@PathVariable Long id) {
		return ResponseEntity.ok(service.listarPorIdCategoria(id));
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> listarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.listarPorNome(nome));
	}

	@GetMapping("/ordenar")
	public ResponseEntity<List<Produto>> ordemAlfa() {
		return ResponseEntity.ok(repository.ordenarPorNome());
	}

	@GetMapping("/ordenarpreco")
	public ResponseEntity<List<Produto>> ordemPreco() {
		return ResponseEntity.ok(repository.ordenarPorPreco());
	}

	@GetMapping("/ordemidcategoria/{id}")
	public ResponseEntity<List<Produto>> ordemidcategoria(@PathVariable Long id) {
		return ResponseEntity.ok(repository.listarPorCategoria(id));
	}

}
