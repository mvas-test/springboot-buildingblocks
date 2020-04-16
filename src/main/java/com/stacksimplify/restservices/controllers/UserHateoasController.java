package com.stacksimplify.restservices.controllers;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNameNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;

@RestController
@RequestMapping(value="/hateoas/users")
@Validated
public class UserHateoasController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public CollectionModel<User> getAllUSers() {
		List<User> allUsers =  userService.getAllUsers();
		allUsers.forEach(user -> {
			Long userid = user.getId();
			Link selflink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
			user.add(selflink);
			
			//Relationship link with orders
			try {
				CollectionModel<Order> orders = WebMvcLinkBuilder.methodOn(OrderHateoasController.class).getAllOrders(userid);
				Link orderslink = WebMvcLinkBuilder.linkTo(orders).withRel("all-orders");
				user.add(orderslink);
			} catch (UserNameNotFoundException ex) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
			}
			
		});
		
		//SelfLink for all users
		Link selflink = WebMvcLinkBuilder.linkTo(this.getClass()).withSelfRel();
		
		CollectionModel<User> userCollectionModel = new CollectionModel<User>(allUsers).add(selflink);
		return userCollectionModel;
		
	}
	
	
	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable("id") @Min(1)Long id) {
		try {
			User user =  userService.getUserById(id).get();
			Long userid = user.getId();
			Link selflink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel(); 
			user.add(selflink);
			EntityModel<User> entityModel = new EntityModel<User>(user);
			return entityModel;
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

}
