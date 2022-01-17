package com.gft.spring.imobiliaria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.spring.imobiliaria.entities.Room;
import com.gft.spring.imobiliaria.repositories.RoomRepository;


@RestController
@RequestMapping(value = "/room")
public class RoomResource {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping
	public ResponseEntity<List<Room>> procurarTodos() {
		List<Room> list = roomRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Room> procurarTodosId(@PathVariable Long Id) {
		Room roo = roomRepository.findById(Id).get();
		return ResponseEntity.ok().body(roo);
	}
}


