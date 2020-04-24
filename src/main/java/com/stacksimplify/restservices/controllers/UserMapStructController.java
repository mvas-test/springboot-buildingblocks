package com.stacksimplify.restservices.controllers;

import java.util.List;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.mappers.UserMapper;
import com.stacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@GetMapping
	public List<UserMsDto> getAllUserDtos() {
		return userMapper.usersListToUsersDtosList(userRepository.findAll());
	}

	// getUserById
	@GetMapping("/{id}")
	public UserMsDto getUserById(@PathVariable("id") @Min(1)Long id) {
		User user = userRepository.findById(id).get();
		return userMapper.userToUserDto(user);
	}
}
