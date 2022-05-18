package com.poke.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poke.model.TemporaryClass;
import com.poke.model.User;
import com.poke.service.RegistrationService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj= service.fetchUserByEmailId(tempEmailId);
			if(userobj!=null) {
				throw new Exception("user with "+tempEmailId+" is already exist");
			}
		}
		User userObj=null;
		userObj=service.saveUser(user);
		return userObj;
		
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj=null;
		if(tempEmailId !=null && tempPass !=null) {
			userObj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj==null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
		
	}

	@PostMapping("update")
	public String updateRating(@RequestBody User user) {
		return service.updateUserById(user);
		
	}
	
//	@PostMapping("update/{id}")
//	public String updateRating(@RequestBody User user,@PathVariable("id") int id) {
//		return service.updateUserById(user, id);
//		
//	}
	
//	@GetMapping("/getuserbyid")
//	public User getUserBasedOnId(@RequestParam("id")int id) throws Exception {
//		if(id==0) {
//			throw new Exception("Invalid Id");
//		}
//		return service.fetchUserById(id);
//	}
	
	@GetMapping("/getalluser")
	public List<User> getAllUsers(){
		return service.getAllUser();
	}
	
}
