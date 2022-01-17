package com.gft.spring.imobiliaria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.spring.imobiliaria.entities.Business;
import com.gft.spring.imobiliaria.repositories.BusinessRepository;


@RestController
@RequestMapping(value = "/business")
public class BusinessResource {
	
	@Autowired
	private BusinessRepository businessRepository;
	
	@GetMapping
	public ResponseEntity<List<Business>> procurarTodos() {
		List<Business> list = businessRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Business> procurarTodosId(@PathVariable Long Id) {
		Business busi = businessRepository.findById(Id).get();
		return ResponseEntity.ok().body(busi);
	}
}


