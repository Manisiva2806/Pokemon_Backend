package com.poke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poke.model.Teams;
import com.poke.model.User;
import com.poke.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	TeamRepository Teamrepo;
	
	public Teams fetchTeamByPokeId(int tempPokeId) {
		return Teamrepo.findByIdd(tempPokeId);
		
	}

	public Teams saveTeam(Teams t) {
		return Teamrepo.save(t);
	}

	public List<Teams> fetchTeamById(int id) {
		return Teamrepo.findAllById(id);
	}
	
}
