package com.gft.spring.imobiliaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.spring.imobiliaria.entities.Business;
import com.gft.spring.imobiliaria.repositories.BusinessRepository;


@Service
public class BusinessService {
	
	@Autowired
	private BusinessRepository businessRepository;
	
	public List<Business> listAll(String keyword) {
		if (keyword != null) {
			return businessRepository.findAll(keyword);
		}
		return businessRepository.findAll();
	}
	
	public void save(Business business) {
		businessRepository.save(business);
	}
	
	public Business get(Long id) {
		return businessRepository.findById(id).get();
	}
	
	public void delete (Long id) {
		businessRepository.deleteById(id);
	}
}
 