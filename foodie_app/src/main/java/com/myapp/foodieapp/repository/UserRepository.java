package com.myapp.foodieapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.foodieapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
