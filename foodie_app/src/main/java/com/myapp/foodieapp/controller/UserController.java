package com.myapp.foodieapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.foodieapp.model.User;
import com.myapp.foodieapp.user_service.UserService;

@RestController
@RequestMapping("/customer")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/allCustomers")
	public Iterable<User> findAll(){
		return userService.getAllCustomerDetails();
	}
	
	@GetMapping("/activeCustomerInfo")
	public List<User> getActiveUser(){
		return userService.getActiveCustomer();
	}
	
	@GetMapping("/inactiveCustomerInfo")
	public List<User> getInActiveUser(){
		return userService.getInActiveCustomer();
	}
	
	@GetMapping("/{id}")
	public Object findByCustomerId(@PathVariable("id") int customerId) throws Exception {
		return userService.findByCustomerId(customerId);
	}
		
	@PostMapping
	public String createUser(@RequestBody User user) {
		return userService.createNewCustomer(user);
	}
	
	@PutMapping
	public String updateUserByID(@RequestBody User user) {
		return userService.updateCustomerInfo(user);
	}
	
	@DeleteMapping
	public String deleteById(@RequestParam int id) {
		return userService.deleteCustomer(id);
	}

	@PatchMapping("/updateMobile")
	public String updateMobile(@RequestBody User user) {
		return userService.updateCustomerMobile(user);
	}
	
	@PatchMapping("/updateAccountStatus")
	public String updateAccountStatus(@RequestBody User user) {
		return userService.updateAccountStatus(user);
	}
}