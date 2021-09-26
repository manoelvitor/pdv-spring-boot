package com.pdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdv.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Usuario findByLogin(String login);
}
