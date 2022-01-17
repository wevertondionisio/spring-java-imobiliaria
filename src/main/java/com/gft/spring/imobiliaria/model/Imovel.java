package com.gft.spring.imobiliaria.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.gft.spring.imobiliaria.entities.Business;
import com.gft.spring.imobiliaria.entities.Category;
import com.gft.spring.imobiliaria.entities.District;
import com.gft.spring.imobiliaria.entities.Room;

@Entity
public class Imovel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	private Category categoria;
	
	@ManyToOne
	private Business negocio;	
	
	@ManyToOne
	private Room quarto;
	
	@ManyToOne
	private District bairro;
	

	public Imovel() {
		
	}
	
	public Imovel(Long id) {
		super();
		this.id = id;
	}
	
	public Imovel(String nome) {
		super();
		this.nome = nome;
	}
	
	

	public Imovel(Long id, String nome, Category categoria, Business negocio, Room quarto, District bairro) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.negocio = negocio;
		this.quarto = quarto;
		this.bairro = bairro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Category getCategoria() {
		return categoria;
	}

	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}

	public Business getNegocio() {
		return negocio;
	}

	public void setNegocio(Business negocio) {
		this.negocio = negocio;
	}

	public Room getQuarto() {
		return quarto;
	}

	public void setQuarto(Room quarto) {
		this.quarto = quarto;
	}

	public District getBairro() {
		return bairro;
	}

	public void setBairro(District bairro) {
		this.bairro = bairro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
