package com.gft.spring.imobiliaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.spring.imobiliaria.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("SELECT p FROM Category p WHERE p.categoria LIKE %?1%")
	public List<Category> findAll(String Keyword);
}
