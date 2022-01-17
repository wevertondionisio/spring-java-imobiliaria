package com.gft.spring.imobiliaria.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.spring.imobiliaria.model.Imovel;


@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
	
	public List<Imovel> findAll();
}
