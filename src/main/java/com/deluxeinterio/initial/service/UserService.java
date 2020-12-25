package com.deluxeinterio.initial.service;

import java.util.List;

import com.deluxeinterio.initial.dto.LoginDto;
import com.deluxeinterio.initial.model.User;

public interface UserService {
	List<User> getAllUsers();
	void insertUser(User user);
	boolean loginUser(LoginDto loginDto);
}