package com.myapp.foodieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.foodieapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Modifying
	@Transactional
	@Query(value="UPDATE User SET mobile = :mobile WHERE id = :id", nativeQuery=true)
	public int updateCustomerMobile(int id, String mobile);
	
	@Query(value="Select * from User where account_inactive = 0", nativeQuery = true)
	public List<User> getActiveCustomer();
	
	@Query(value="Select * from User where account_inactive = 1", nativeQuery = true)
	public List<User> getInActiveCustomer();
	
	@Modifying
	@Transactional
	@Query(value="UPDATE User SET account_inactive = :accountStatus WHERE id = :id", nativeQuery = true)
	public int updateAccountStatus(int id, int accountStatus);

}