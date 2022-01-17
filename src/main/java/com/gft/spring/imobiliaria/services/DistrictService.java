package com.gft.spring.imobiliaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.spring.imobiliaria.entities.District;
import com.gft.spring.imobiliaria.repositories.DistrictRepository;


@Service
public class DistrictService {
	
	@Autowired
	private DistrictRepository districtRepository;
	

	public List<District> listAll(String keyword) {
		if (keyword != null) {
			return districtRepository.findAll(keyword);
		}
		return districtRepository.findAll();
	}
	
	public List<District> listAll() {
		return districtRepository.findAll();
	}
	
	public void save(District district) {
		districtRepository.save(district);
	}
	
	public District get(Long id) {
		return districtRepository.findById(id).get();
	}
	
	public void delete (Long id) {
		districtRepository.deleteById(id);
	}
}
 