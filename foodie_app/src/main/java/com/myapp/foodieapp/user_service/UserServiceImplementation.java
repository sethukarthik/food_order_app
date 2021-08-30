package com.myapp.foodieapp.user_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myapp.foodieapp.enums.UserProfileEnums;
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
		try {			
			return userRepo.findAll(); 
		} catch (DataAccessException ex) {
			System.out.println(ex.getLocalizedMessage());
			return null;
		}
	}
	
	@Override
	public Object findByCustomerId(int customerId){
		Optional<User> user = userRepo.findById(customerId);
		if(user.isPresent()) {				
			return user;
		} else {
			return null;
		}
	}

	@Override
	public String createNewCustomer(User user) {
		try {
			userRepo.save(user);
			return "User has been created successfull";
		} catch(DataAccessException ex) {
			System.out.println(ex.getLocalizedMessage());
			return null;
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
		userRepo.updateCustomerMobile(user.getId(), user.getMobile());
		return "Mobile Number updated";
	}

	@Override
	public List<User> getActiveCustomer() {
		return userRepo.getActiveCustomer();
	}

	@Override
	public List<User> getInActiveCustomer() {
		return userRepo.getInActiveCustomer();
	}
	
	@Override
	public String updateAccountStatus(User user) {
		try {
			userRepo.updateAccountStatus(user.getId(), getAccountStatusFromEnum(user));
			return "Account deactivated";
		} catch (DataAccessException e) {
			return e.getLocalizedMessage();
		}
	}
	
	private static int getAccountStatusFromEnum(User user) {
		return user.getAccountStatus().equals(UserProfileEnums.ACTIVE) ? 0 : 1; 
	}
}