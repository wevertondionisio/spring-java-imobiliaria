package com.gft.spring.imobiliaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.spring.imobiliaria.model.Imovel;
import com.gft.spring.imobiliaria.repositories.ImovelRepository;


@Service
public class ImovelService {
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	public List<Imovel> listAll() {
		return imovelRepository.findAll();
	}
	
	public void save(Imovel imovel) {
		imovelRepository.save(imovel);
	}
	
	public Imovel get(Long id) {
		return imovelRepository.findById(id).get();
	}
	
	public void delete (Long id) {
		imovelRepository.deleteById(id);
	}
}
 