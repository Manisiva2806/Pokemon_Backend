package com.poke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poke.model.Teams;


public interface TeamRepository extends JpaRepository<Teams,Integer>{
	
	public Teams findByIdd(int tempPokeId);

	public List<Teams> findAllById(int id);

}
