package com.myapp.foodieapp.user_service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myapp.foodieapp.model.User;
import com.myapp.foodieapp.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public UserServiceImplementation() {
	}

	@Override
	public Iterable<User> getAllCustomerDetails() {
		return userRepo.findAll(); 
	}
	
	@Override
	public Object findByCustomerId(int customerId){
		Optional<User> user = userRepo.findById(customerId);
		if(user.isPresent()) {				
			return user;
		} else {
			return "No customer found for the id: " + customerId;
		}
	}

	@Override
	public String createNewCustomer(User user) {
		Optional<User> userSave = Optional.ofNullable(user);
		User u = new User();
		if(userSave.isPresent()) {			
			userRepo.save(user);
			return "User has been created successfull";
		} else {
			return "Something went wrong";
		}
	}

	@Override
	public String updateCustomerInfo(User user) {
		Optional<User> userSave = Optional.ofNullable(user);
		User u = new User();
		if(userSave.isPresent()) {			
			userRepo.save(user);
			return "User info updated successfull";
		} else {
			return "Something went wrong";
		}	
	}
	
	@Override
	public String deleteCustomer(int id) {
		userRepo.deleteById(id);
		return "Customer account deleted";
	}

	@Override
	public String updateCustomerMobile(User user) {
		System.out.println(user);
		userRepo.updateCustomerMobile(user.getId(), user.getMobile());
		return "Mobile Number updated";
	}
}