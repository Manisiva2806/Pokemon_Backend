package com.poke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.poke.model.TemporaryClass;
import com.poke.model.User;
import com.poke.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository UserRepo;

	public User saveUser(User user) {
		return UserRepo.save(user);
	}

	public User fetchUserByEmailId(String email) {
		return UserRepo.findAllByEmailId(email);

	}

	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return UserRepo.findAllByEmailIdAndPassword(email, password);

	}

//	public User fetchUserById(int id) {
//		return UserRepo.findById(id);
//	}

	public List<User> getAllUser() {
		return UserRepo.findAll();
	}

	public String updateUserById(User user) {
    	UserRepo.findById(user.getId()).map(u->{u.setXpRating(u.getXpRating()-user.getXpRating());
    	return UserRepo.save(u);});
    	return "Updated";

    }

}
