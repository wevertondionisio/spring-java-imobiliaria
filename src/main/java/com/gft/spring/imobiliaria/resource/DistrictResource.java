package com.gft.spring.imobiliaria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.spring.imobiliaria.entities.District;
import com.gft.spring.imobiliaria.repositories.DistrictRepository;


@RestController
@RequestMapping(value = "/districts")
public class DistrictResource {
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@GetMapping
	public ResponseEntity<List<District>> procurarTodos() {
		List<District> list = districtRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<District> procurarTodosId(@PathVariable Long Id) {
		District dist = districtRepository.findById(Id).get();
		return ResponseEntity.ok().body(dist);
	}
}


