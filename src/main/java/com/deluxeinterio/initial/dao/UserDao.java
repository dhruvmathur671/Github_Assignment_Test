package com.deluxeinterio.initial.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deluxeinterio.initial.model.User;

@Repository
public interface UserDao  extends CrudRepository <User, Integer>  {

	@Query(value = "SELECT obj.user_password FROM user obj where obj.user_name=?1", nativeQuery = true)
	String getStoredPassword(String userName);
	

}