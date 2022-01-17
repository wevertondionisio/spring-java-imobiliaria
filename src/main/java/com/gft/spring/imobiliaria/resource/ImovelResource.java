package com.gft.spring.imobiliaria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.spring.imobiliaria.model.Imovel;
import com.gft.spring.imobiliaria.repositories.ImovelRepository;


@RestController
@RequestMapping(value = "/imovel")
public class ImovelResource {
	
	@Autowired
	private ImovelRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Imovel>> procurarTodos() {
		List<Imovel> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Imovel> procurarTodosId(@PathVariable Long Id) {
		Imovel imo = categoryRepository.findById(Id).get();
		return ResponseEntity.ok().body(imo);
	}
}


