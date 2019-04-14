package com.mendonca.repository;

import org.springframework.data.repository.CrudRepository;

import com.mendonca.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
	//public User findUsernameAndPassword(String username,String password);
	public User findByUsernameAndPassword(String username, String password);
	
	
}
