package com.primesource.restapi.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primesource.restapi.dao.UserDAO;
import com.primesource.restapi.model.User;
import com.primesource.restapi.randomuser.RandomUser;

@RestController
@RequestMapping("/primesource")
public class UserController {

	@Autowired
	UserDAO userDAO;

	/* create user */
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userDAO.save(user);

	}

	@PostMapping("/users/random")
	public User createUserfromRandomAPI() throws IOException, ParseException, java.text.ParseException {
		RandomUser ru = new RandomUser();
		return userDAO.save(ru.getUser());
	}

	/* get all users from database */
	@GetMapping("/users")
	public List<User> getllUsers() {
		return userDAO.findAll();
	}

	/* search user by id */
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
		User user = userDAO.getOne(userId);

		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);

	}

	/* update user info */
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) {
		User user = userDAO.getOne(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		user.setCity(userDetails.getCity());
		user.setEmail(userDetails.getEmail());
		user.setGender(userDetails.getGender());
		user.setPassword(userDetails.getPassword());
		user.setPhone(userDetails.getPhone());
		user.setPostcode(userDetails.getPostcode());
		user.setRegistered(userDetails.getRegistered());
		user.setState(userDetails.getState());
		user.setStreet(userDetails.getStreet());
		user.setUsername(userDetails.getUsername());

		User updatedUser = userDAO.save(user);
		return ResponseEntity.ok().body(updatedUser);

	}

	/* delete user */
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userId) {
		User user = userDAO.getOne(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		userDAO.delete(user);
		return ResponseEntity.ok().build();

	}

}
