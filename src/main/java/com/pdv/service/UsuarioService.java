package com.pdv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pdv.model.Usuario;
import com.pdv.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	
	public Usuario save(Usuario obj) {
		obj.setSenha(new BCryptPasswordEncoder().encode(obj.getSenha())); 
		repository.save(obj);
		return obj;
	}
}
