package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;

@Service
public class UserService {

	//Autowire the UserRepository
	@Autowired
	private UserRepository userRepository;

	//getAllUsers method
	public List<User> getAllUsers() {		
		return userRepository.findAll();	
	}

	//createUser method
	public User createUser(User user) throws UserExistsException {

		User tempUser = userRepository.findByUsername(user.getUsername());
		if (tempUser != null) {
			throw new UserExistsException("USer already exists in User Repository!");
		}

		return userRepository.save(user);
	}

	//getUserById
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("USer Not Found in User Repository");
		}

		return user;
	}

	//updateUSerById
	public User updateUserById(Long id, User user) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(id);
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("USer Not Found in User Repository!  Please, provide the correct UserID.");
		}

		user.setId(id);
		return userRepository.save(user);
	}

	//deleteUSerById
	public void deleteUSerById(Long id)  {

		Optional<User> optionalUser = userRepository.findById(id);
		if (!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "USer Not Found in User Repository!  Please, provide the correct UserID.");
		}

		userRepository.deleteById(id);
	}	

	//getUserByUsername
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
