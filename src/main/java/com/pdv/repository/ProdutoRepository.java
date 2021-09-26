package com.pdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdv.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
