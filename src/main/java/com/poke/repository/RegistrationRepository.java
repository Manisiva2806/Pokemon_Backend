package com.poke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poke.model.User;

public interface RegistrationRepository extends JpaRepository<User,Integer>{

	public User findAllByEmailId(String emailId);

	public User findAllByEmailIdAndPassword(String emailId, String password);

//	public User findAllById(int id);

}
