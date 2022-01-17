package com.gft.spring.imobiliaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.spring.imobiliaria.entities.Category;
import com.gft.spring.imobiliaria.repositories.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> listAll(String keyword) {
		if (keyword != null) {
			return categoryRepository.findAll(keyword);
		}
		return categoryRepository.findAll();
	}
	
	public void save(Category category) {
		categoryRepository.save(category);
	}
	
	public Category get(Long id) {
		return categoryRepository.findById(id).get();
	}
	
	public void delete (Long id) {
		categoryRepository.deleteById(id);
	}
}
 