package com.myapp.foodieapp.user_service;

import com.myapp.foodieapp.model.User;

public interface UserService {
	
	Iterable<User> getAllCustomerDetails();
	
	Object findByCustomerId(int customerId);
	
	String createNewCustomer(User user);
	
	String updateCustomerInfo(User user);
	
	String deleteCustomer(int id);
	
	String updateCustomerMobile(User user);
	
}