package com.gft.spring.imobiliaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.spring.imobiliaria.entities.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
	
	@Query("SELECT p FROM District p WHERE p.nome LIKE %?1%")
	public List<District> findAll(String Keyword);
}
