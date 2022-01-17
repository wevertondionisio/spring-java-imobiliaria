package com.gft.spring.imobiliaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.spring.imobiliaria.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	@Query("SELECT p FROM Room p WHERE p.quarto LIKE %?1%")
	public List<Room> findAll(String Keyword);
}
