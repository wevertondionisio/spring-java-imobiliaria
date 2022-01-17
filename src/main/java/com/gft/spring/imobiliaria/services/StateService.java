package com.gft.spring.imobiliaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.spring.imobiliaria.entities.State;
import com.gft.spring.imobiliaria.repositories.StateRepository;


@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	public List<State> listAll(String keyword) {
		if (keyword != null) {
			return stateRepository.findAll(keyword);
		}
		return stateRepository.findAll();
	}
	
	public void save(State state) {
		stateRepository.save(state);
	}
	
	public State get(Long id) {
		return stateRepository.findById(id).get();
	}
	
	public void delete (Long id) {
		stateRepository.deleteById(id);
	}

}
 