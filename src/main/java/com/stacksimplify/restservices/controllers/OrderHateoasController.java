package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.OrderNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNameNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value="/hateoas/users")
public class OrderHateoasController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/{userid}/orders")
	public CollectionModel<Order> getAllOrders(@PathVariable Long userid) throws UserNameNotFoundException {
		Optional<User> userOptional = userRepository.findById(userid);
		if (!userOptional.isPresent()) {
			throw new UserNameNotFoundException("User Not Found");
		}
		
		List<Order> allOrders = userOptional.get().getOrders();
		CollectionModel<Order> allOrdersCollectionModel = new CollectionModel<Order>(allOrders);
		
		return allOrdersCollectionModel; 		
	}
	
	@GetMapping("/{userid}/orders/{orderid}")
	public Order getOrderByOrderId(@PathVariable Long userid, @PathVariable Long orderid) throws UserNameNotFoundException, OrderNotFoundException {
		Optional<User> userOptional = userRepository.findById(userid);
		if (!userOptional.isPresent()) {
			throw new UserNameNotFoundException("User Not Found");
		}

		//searches user with {userid} orders
		Order order = userOptional.get().findOrder(orderid);
		if (order == null) {
			throw new OrderNotFoundException("Order Not Found");
		}	

		return order;
	}

}
