package com.pdv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	private List<Produto> compra = new ArrayList<Produto>();

	private Double vlCompra;

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getCompra() {
		return compra;
	}

	public void setCompra(List<Produto> compra) {
		this.compra = compra;
	}

	public Double getVlCompra() {
		return vlCompra;
	}

	public void setVlCompra(Double vlCompra) {
		this.vlCompra = vlCompra;
	}

	
	

}
