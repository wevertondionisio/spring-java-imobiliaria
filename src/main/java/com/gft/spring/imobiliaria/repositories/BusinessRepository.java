package com.gft.spring.imobiliaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.spring.imobiliaria.entities.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
	
	@Query("SELECT p FROM Business p WHERE p.negocio LIKE %?1%")
	public List<Business> findAll(String Keyword);
}
