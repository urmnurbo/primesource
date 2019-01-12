package com.primesource.restapi.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primesource.restapi.model.User;
import com.primesource.restapi.repository.UserRepository;

@Service
public class UserDAO {

	@Autowired
	UserRepository userRepository;
	
	//save user
	public User save(User user) {
		return userRepository.save(user);
		
	}
	
	//get all
	public List<User> findAll(){
		return userRepository.findAll(); 
	}
	
	/*get by id*/
	public User getOne(Long id) {
		return userRepository.findById(id).get();
		
	}
	public List<User> getByUsername(String username) {
		return userRepository.findByUsernameContainingIgnoreCase(username);
		
	}
	//delete user
	public void delete(User user) {
		userRepository.delete(user);
	}
}
