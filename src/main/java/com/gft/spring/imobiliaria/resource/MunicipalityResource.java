package com.gft.spring.imobiliaria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.spring.imobiliaria.entities.Municipality;
import com.gft.spring.imobiliaria.repositories.MunicipalityRepository;


@RestController
@RequestMapping(value = "/municipalities")
public class MunicipalityResource {
	
	@Autowired
	private MunicipalityRepository municipalitiesRepository;
	
	@GetMapping
	public ResponseEntity<List<Municipality>> procurarTodos() {
		List<Municipality> list = municipalitiesRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Municipality> procurarTodosId(@PathVariable Long Id) {
		Municipality muni = municipalitiesRepository.findById(Id).get();
		return ResponseEntity.ok().body(muni);
	}
}


