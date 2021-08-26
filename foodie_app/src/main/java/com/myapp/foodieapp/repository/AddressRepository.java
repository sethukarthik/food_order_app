package com.myapp.foodieapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.foodieapp.model.Address;
import com.myapp.foodieapp.model.User;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
	

}
