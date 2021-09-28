package com.pdv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pdv.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	
	@Query("select p from Produto p join p.categorias c where c.id=?1")
	List<Produto> listarPorCategoria(Long id);

	@Query("select p from Produto p where p.nome=?1")
	List<Produto> listarPorNome(String nome);
	
	@Query("SELECT p FROM Produto p ORDER BY p.nome")
	List<Produto> ordenarPorNome();
	
	@Query("SELECT p FROM Produto p ORDER BY p.preco")
	List<Produto> ordenarPorPreco();



}
