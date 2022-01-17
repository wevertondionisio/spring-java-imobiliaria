package com.gft.spring.imobiliaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.spring.imobiliaria.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
	
	@Query("SELECT p FROM State p WHERE p.nome LIKE %?1%")
	public List<State> findAll(String Keyword);
}
