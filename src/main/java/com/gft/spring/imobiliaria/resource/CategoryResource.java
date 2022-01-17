package com.gft.spring.imobiliaria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.spring.imobiliaria.entities.Category;
import com.gft.spring.imobiliaria.repositories.CategoryRepository;


@RestController
@RequestMapping(value = "/categoria")
public class CategoryResource {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Category>> procurarTodos() {
		List<Category> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> procurarTodosId(@PathVariable Long Id) {
		Category cat = categoryRepository.findById(Id).get();
		return ResponseEntity.ok().body(cat);
	}
}


