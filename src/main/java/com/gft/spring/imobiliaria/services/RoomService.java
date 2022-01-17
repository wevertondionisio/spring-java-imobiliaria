package com.gft.spring.imobiliaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.spring.imobiliaria.entities.Room;
import com.gft.spring.imobiliaria.repositories.RoomRepository;


@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public List<Room> listAll(String keyword) {
		if (keyword != null) {
			return roomRepository.findAll(keyword);
		}
		return roomRepository.findAll();
	}
	
	public void save(Room room) {
		roomRepository.save(room);
	}
	
	public Room get(Long id) {
		return roomRepository.findById(id).get();
	}
	
	public void delete (Long id) {
		roomRepository.deleteById(id);
	}
}
 