package com.myapp.foodieapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.foodieapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Modifying
	@Query(value="UPDATE User SET mobile = :mobile WHERE id = :id", nativeQuery=true)
	public int updateCustomerMobile(int id, String mobile);

}
