package com.gft.spring.imobiliaria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.spring.imobiliaria.entities.State;
import com.gft.spring.imobiliaria.repositories.StateRepository;


@RestController
@RequestMapping(value = "/states")
public class StateResource {
	
	@Autowired
	private StateRepository stateRepository;
	
	@GetMapping
	public ResponseEntity<List<State>> procurarTodos() {
		List<State> list = stateRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<State> procurarTodosId(@PathVariable Long Id) {
		State sta = stateRepository.findById(Id).get();
		return ResponseEntity.ok().body(sta);
	}
}


