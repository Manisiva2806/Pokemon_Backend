package com.poke.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poke.model.Teams;
import com.poke.service.TeamService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TeamController {
	
	@Autowired
	TeamService service;
	
	@RequestMapping(value="/teams",method = RequestMethod.POST,
	consumes=MediaType.APPLICATION_JSON_VALUE)
	public Teams teams(@RequestBody Teams t) throws Exception {
		int tempPokeId=t.getIdd();
		if(tempPokeId != 0) {
			Teams userobj= service.fetchTeamByPokeId(tempPokeId);
			if(userobj!=null) {
				throw new Exception(tempPokeId+" is already exist");
			}
		}
		Teams userObj=null;
		userObj=service.saveTeam(t);
		return userObj;
		
	}
	
	@GetMapping("/getdetailsofteam/{id}")
	public List<Teams> getTeamDetail(@PathVariable int id) throws Exception {
		if(id==0) {
			throw new Exception("Invalid Id");
		}
		return service.fetchTeamById(id);
	}
	
}
