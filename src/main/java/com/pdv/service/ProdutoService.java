package com.pdv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdv.model.Categoria;
import com.pdv.model.Produto;
import com.pdv.repository.CategoriaRepository;
import com.pdv.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	/*
	 * @Autowired private CategoriaRepository catRepository;
	 */
	public Produto save(Produto obj) {
		/*
		 * for (Categoria c : obj.getCategorias()) { Categoria cat =
		 * catRepository.getById(c.getId()); cat.getProdutos().add(obj); }
		 */
		return repository.save(obj);
	}



	public List<Produto> listarPorIdCategoria(Long id) {
		List<Produto> obj = new ArrayList<Produto>();
		for (Produto p : repository.findAll()) {
			for (Categoria c : p.getCategorias()) {
				if (c.getId() == id) {
					obj.add(p);
					System.out.println(id == c.getId());

				}
				else {
					System.out.println(id == c.getId());

				}


			}
		}
		return obj;
	}

}
