package com.gft.spring.imobiliaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.spring.imobiliaria.entities.Municipality;
import com.gft.spring.imobiliaria.repositories.MunicipalityRepository;


@Service
public class MunicipalityService {
	
	@Autowired
	private MunicipalityRepository municipalityRepository;
	
	
	public List<Municipality> listAll(String keyword) {
		if (keyword != null) {
			return  municipalityRepository.findAll(keyword);
		}
		return municipalityRepository.findAll();
	}
	
	public void save(Municipality municipality) {
		municipalityRepository.save(municipality);
	}
	
	public Municipality get(Long id) {
		return municipalityRepository.findById(id).get();
	}
	
	public void delete (Long id) {
		municipalityRepository.deleteById(id);
	}
}
 