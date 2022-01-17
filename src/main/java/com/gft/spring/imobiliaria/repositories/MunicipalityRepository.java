package com.gft.spring.imobiliaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.spring.imobiliaria.entities.Municipality;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
	
	@Query("SELECT p FROM Municipality p WHERE p.nome LIKE %?1%")
	public List<Municipality> findAll(String Keyword);
}
