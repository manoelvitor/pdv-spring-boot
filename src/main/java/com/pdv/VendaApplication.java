package com.pdv;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pdv.model.Categoria;
import com.pdv.model.Cliente;
import com.pdv.model.Produto;
import com.pdv.repository.CategoriaRepository;
import com.pdv.repository.ClienteRepository;
import com.pdv.repository.ProdutoRepository;

@SpringBootApplication
public class VendaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(VendaApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));	
		System.out.println("ola");	

	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria("Informática");
		Categoria c2 = new Categoria("Papelaria");
		Categoria c3 = new Categoria("Alimenticio");
		Categoria c4 = new Categoria("Eletrodoméstico");
		Categoria c5 = new Categoria("Limpeza");
		Categoria c6 = new Categoria("Higiene Pessoal");
		Categoria c7 = new Categoria("Alcolicas");
		Categoria c8 = new Categoria("Bebidas");
		Categoria c9 = new Categoria("Utensilios Domésticos");
		Categoria c10 = new Categoria("Vestuário");

		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c4, c5, c6, c7, c8, c9, c10));

		
		Produto p1 = new Produto("Notebook Dell", 3000.00);
		p1.setCategorias(Arrays.asList(c1, c2));

		
		Produto p2 = new Produto("Cafeteira Philco", 400.00);
		p2.setCategorias(Arrays.asList(c4, c9));

		Produto p3 = new Produto("Camiseta Hering", 50.00);
		p3.setCategorias(Arrays.asList(c10));

		Produto p4 = new Produto("Refrigerante Coca-Cola 2l", 9.00);
		p4.setCategorias(Arrays.asList(c8));

		Produto p5 = new Produto("Arroz Tio João", 19.00);
		p5.setCategorias(Arrays.asList(c3));
		
		Produto p6 = new Produto("Impressora Epson", 1900.00);
		p6.setCategorias(Arrays.asList(c1,c2));
		

		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
		



		Cliente cli1 = new Cliente();
		cli1.setCompra(Arrays.asList(p1,p1));

			
		clienteRepository.saveAll(Arrays.asList(cli1));
	}

}
