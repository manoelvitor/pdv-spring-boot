package com.pdv.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdv.model.Cliente;
import com.pdv.repository.ClienteRepository;
import com.pdv.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteService service;
	

	@GetMapping
	public ResponseEntity<List<Cliente>> getall() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> getall(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> post(@RequestBody Cliente obj) {
		return ResponseEntity.ok(service.save(obj));
	}
	
	
	@PutMapping("/calcular")
	public ResponseEntity<Cliente> calc(@RequestBody Cliente obj) {
		return ResponseEntity.ok(service.calcularCompra(obj));
	}
	
	


}
